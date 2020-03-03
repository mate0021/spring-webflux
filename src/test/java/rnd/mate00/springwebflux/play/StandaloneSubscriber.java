package rnd.mate00.springwebflux.play;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class StandaloneSubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
//        super.hookOnSubscribe(subscription); // using this will call super, and thus show default onNext messages etc
        System.out.println("Subscribing by standalone class.");
        requestUnbounded(); // we can either call requestUnbounded here and not request anywhere else,
                            // or request(1) here and request(1) in hookOnNext
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println("Received " + value);
//        request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Done.");
    }
}
