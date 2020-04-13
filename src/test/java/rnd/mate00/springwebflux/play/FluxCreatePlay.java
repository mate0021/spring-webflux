package rnd.mate00.springwebflux.play;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.List;
import java.util.function.Consumer;

public class FluxCreatePlay {

    @Test
    public void bridgeBetweenOldApiAndReactive() {
        OldEventProcessor oldProcessor = new OldEventProcessor();

        Flux<String> strings = Flux.create(new Consumer<FluxSink<String>>() {
            @Override
            public void accept(FluxSink<String> stringFluxSink) {
                oldProcessor.registerListener(new OldEventListener<String>() {
                    @Override
                    public void onDataChunk(List<String> chunk) {
                        for (String s : chunk) {
                            stringFluxSink.next(s);
                        }
                    }

                    @Override
                    public void processComplete() {
                        stringFluxSink.complete();
                    }
                });
            }
        });
    }
}

interface OldEventListener<T> {
    void onDataChunk(List<T> chunk);
    void processComplete();
}

class OldEventProcessor {
    private OldEventListener<String> listener;

    void registerListener(OldEventListener<String> listener) {
        this.listener = listener;
    }
}