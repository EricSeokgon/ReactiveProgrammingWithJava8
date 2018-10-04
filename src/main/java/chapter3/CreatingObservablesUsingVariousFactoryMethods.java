package chapter3;

import common.Program;
import rx.Observable;

import java.util.concurrent.TimeUnit;

import static common.Helpers.subscribePrint;

public class CreatingObservablesUsingVariousFactoryMethods implements Program {

    @Override
    public String name() {
        return "A few factory methods for creating Observables";
    }

    @Override
    public int chapter() {
        return 3;
    }

    @Override
    public void run() {
        subscribePrint(Observable.interval(500L, TimeUnit.MILLISECONDS),
                "Interval Observable");

        subscribePrint(Observable.timer(0L, 1L, TimeUnit.SECONDS),
                "Timed Interval Observable");

        subscribePrint(Observable.timer(1L, TimeUnit.SECONDS),
                "Timer Observable");

        subscribePrint(Observable.error(new Exception("Test Error!")),
                "Error Observable");

        subscribePrint(Observable.empty(), "Empty Observable");
        subscribePrint(Observable.never(), "Never Observable");

        subscribePrint(Observable.range(1, 10), "Range Observable");

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }

    }

    public static void main(String[] args) {
        new CreatingObservablesUsingVariousFactoryMethods().run();
    }

}
