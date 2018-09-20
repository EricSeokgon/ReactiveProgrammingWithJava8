package chapter1;

import common.Program;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ObservableVSIterator implements Program {


    public String name() {
        return "Iterator vs Observable";
    }

    public int chapter() {
        return 1;
    }

    public void run() {
        System.out.println("Running Iterator example:");
        usingIteratorExample();

        System.out.println("Running Observable example:");
        usingObservableExample();
    }

    private void usingObservableExample() {
        List<String> list = Arrays
                .asList("One", "Two", "Three", "Four", "Five");

        Observable<String> observable = Observable.from(list);

        // Subscribe to the Observable. It will PUSH it's values to the Subscriber, and it will be printed.
        observable.subscribe(new Action1<String>() {
            public void call(String element) {
                System.out.println(element);
            }
        }, new Action1<Throwable>() {
            public void call(Throwable t) {
                System.err.println(t); // (1)
            }
        }, new Action0() {
            public void call() {
                System.out.println("We've finnished!"); // (2)
            }
        });
    }

    private void usingIteratorExample() {
        List<String> list = Arrays
                .asList("One", "Two", "Three", "Four", "Five");

        Iterator<String> iterator = list.iterator();

        // While there is a next element, PULL it from the source and print it.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
