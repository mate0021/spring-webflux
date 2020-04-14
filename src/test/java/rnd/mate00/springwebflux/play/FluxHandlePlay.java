package rnd.mate00.springwebflux.play;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.function.BiConsumer;

/*
https://projectreactor.io/docs/core/release/reference/index.html#_handle
 */
public class FluxHandlePlay {

    @Test
    public void createRange_And_Use_Mapping_Function_With_Proper_Input() {
        Flux.range(65, 26) // <-- correct input
                .doOnNext(System.out::println) // <-- show the input
                .map(this::getLetter) // <-- map it, and so on...
                .log()
                .subscribe();
    }

    @Test
    public void createRange_Use_Wrong_Input() {
        Flux.range(80, 16)
                .doOnNext(System.out::println)
                .map(this::getLetter)
                .log()
                .doOnError(e -> {
                    System.err.println("We have NPE here...");
                })
                .subscribe();
    }

    @Test
    public void useHandle_To_Filter_Out_Wrong_Input() {
        Flux.range(80, 16)
                .doOnNext(System.out::println)
                .handle(new BiConsumer<Integer, SynchronousSink<String>>() {
                    @Override
                    public void accept(Integer code, SynchronousSink<String> synchronousSink) {
                        String result = getLetter(code);
                        if (result == null) {
                            System.out.println(code + " is a wrong input");
                        } else {
                            synchronousSink.next(result);
                        }
                    }
                })
                .log()
                .subscribe();
    }

    private String getLetter(int code) {
        if (code < 65 || code > 90) {
            return null;
        }

        return "" + (char) code;
    }
}
