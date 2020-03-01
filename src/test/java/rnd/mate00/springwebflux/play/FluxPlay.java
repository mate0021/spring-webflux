package rnd.mate00.springwebflux.play;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.function.Consumer;

public class FluxPlay {

    private static final Flux<String> flux = Flux.just("1", "2", "3", "4");

    @Test
    public void nothingHappens() {
        flux.log();
    }

    @Test
    public void youHaveToSubscribe() {
        flux
                .log()
                .subscribe();
    }

    @Test
    public void customSubscriber() {
        flux
                .log()
                .subscribe(s -> System.out.println(s.length()));
    }

    @Test
    public void doOnEvents() {
        flux.log()
                .doOnSubscribe(s -> System.out.println("subscribing..."))
                .doOnNext(s -> System.out.println("next element " + s))
                .doOnComplete(() -> System.out.println("sequence completed"))
                .subscribe();
    }

    @Test
    public void fromIterable() {
        Flux<Integer> flux = Flux.fromIterable(Arrays.asList(3, 4, 5, 6, 7, 8));

        flux.log().subscribe();
    }

    @Test
    public void handleOneCaseDifferentlyAndThrowError() {
        Flux<Integer> ints = Flux.range(1, 5);

        ints.map(i -> {
            if (i < 4) {
                return i;
            }
            throw new RuntimeException("Too big value!");
        })
//                .log()
                .subscribe(System.out::println);
    }

    @Test
    public void handleOneCaseDifferently_ThrowError_CatchItInSubscriber() {
        Flux<Integer> ints = Flux.range(1, 5);

        ints.map(i -> {
            if (i < 4) {
                return i;
            }
            throw new RuntimeException("Too big value, but let's catch it");
        })
//                .log()
                .subscribe(i -> {}, e -> { System.out.println(e);});
    }
}
