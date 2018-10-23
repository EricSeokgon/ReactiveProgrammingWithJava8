package chapter4;

import common.Program;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.TimeInterval;
import rx.schedulers.Timestamped;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static common.Helpers.subscribePrint;

public class VariousTransformationsDemonstration implements Program {

    @Override
    public String name() {
        return "Demonstration of working with the cast, materialize, timestamp and timeInterval operators";
    }

    @Override
    public int chapter() {
        return 4;
    }

    @Override
    public void run() {
        List<Number> list = Arrays.asList(1, 2, 3);
        Observable<Integer> iObs = Observable.from(list).cast(Integer.class);

        subscribePrint(iObs, "Integers");

        Observable<Timestamped<Number>> timestamp = Observable.from(list)
                .timestamp();

        subscribePrint(timestamp, "Timestamps");

        Observable<TimeInterval<Long>> timeInterval = Observable.timer(0L,
                150L, TimeUnit.MILLISECONDS).timeInterval();

        Subscription sub = subscribePrint(timeInterval, "Time intervals");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
        }
        sub.unsubscribe();
    }

    public static void main(String[] args) {
        new VariousTransformationsDemonstration().run();
    }
}
