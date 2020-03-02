package rnd.mate00.springwebflux.play;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class StandaloneSubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
//        super.hookOnSubscribe(subscription); // using this will call super, and thus show default onNext messages etc
        System.out.println("Subscribing by standalone class.");
    }

    @Override
    protected void hookOnNext(T value) {
        super.hookOnNext(value);
        System.out.println("Received " + value);
    }

    @Override
    protected void hookOnComplete() {
        super.hookOnComplete();
        System.out.println("Done.");
    }
}
