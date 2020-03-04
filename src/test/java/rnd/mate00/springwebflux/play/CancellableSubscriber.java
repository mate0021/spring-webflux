package rnd.mate00.springwebflux.play;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class CancellableSubscriber extends BaseSubscriber<Integer> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        requestUnbounded();
    }

    @Override
    protected void hookOnNext(Integer value) {
        System.out.println("Received value: " + value);
        if (Integer.valueOf(value) > 5) {
            System.out.println("This is too much for us. Cancelling...");
            cancel();
        }
    }

    @Override
    protected void hookOnCancel() {
        System.out.println("Executing cancel.");
    }
}
