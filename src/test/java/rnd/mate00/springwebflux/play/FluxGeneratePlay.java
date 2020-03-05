package rnd.mate00.springwebflux.play;

import org.junit.Test;
import reactor.core.publisher.Flux;

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
}
