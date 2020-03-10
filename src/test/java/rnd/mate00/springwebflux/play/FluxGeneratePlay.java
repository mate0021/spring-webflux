package rnd.mate00.springwebflux.play;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FluxGeneratePlay {

    @Test
    public void synchronousEmission_SimpleGenerator() {
        Flux<Object> generate = Flux.generate(
                () -> 0, // callable that initiates state
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) {
                        sink.complete();
                    }
                    return state + 1;
                });

        generate.log().subscribe();
    }

    @Test(timeout = 1000)
    public void generateUsingAnonymousClasses_ItWillGoEndlessly() {
        Flux<String> strs = Flux.generate(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("initial callable");
                return "A";
            }
        }, new BiFunction<String, SynchronousSink<String>, String>() {
            @Override // we have to stop it somewhere here by ie. tSynschonousSink.complete()
            public String apply(String s, SynchronousSink<String> tSynchronousSink) {
                System.out.println("bifunc as a generator function");
                tSynchronousSink.next(s + "A");
                return s + "A";
            }
        }, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("ending consumer will free resources");
            }
        });

        strs.log().subscribe();
    }

    @Test
    public void callCompleteInGeneratorFunction() {
        Flux<String> strs = Flux.generate(
                () -> "A",
                new BiFunction<String, SynchronousSink<String>, String>() {
                    @Override
                    public String apply(String s, SynchronousSink<String> stringSynchronousSink) {
                        stringSynchronousSink.next(s + "A");
                        if (s.length() == 10) {
                            stringSynchronousSink.complete();
                        }
                        return s + "B";
                    }
                },
                System.out::println
        );

        strs.log().subscribe();
    }

    @Test
    public void generatorWithState() {
        Flux<String> strs = Flux.generate(
                AtomicInteger::new,
                new BiFunction<AtomicInteger, SynchronousSink<String>, AtomicInteger>() {
                    @Override
                    public AtomicInteger apply(AtomicInteger integerState, SynchronousSink<String> stringSynchronousSink) {
                        int i = integerState.incrementAndGet();
                        if (i > 10) {
                            stringSynchronousSink.complete();
                        }
                        stringSynchronousSink.next(String.valueOf(i));
                        return integerState;
                    }
                }
        );

        strs.log().subscribe();
    }
}
