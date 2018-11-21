package chapter8;

import common.CreateObservable;
import common.Helpers;
import common.Program;

import rx.Observable;
import rx.Observable.Transformer;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Compose implements Program {

    public static class OddFilter<T> implements Transformer<T, T> {

        @Override
        public Observable<T> call(Observable<T> observable) {
            return observable
                    .lift(new Lift.Indexed<T>(1L))
                    .filter(pair -> pair.getLeft() % 2 == 1)
                    .map(pair -> pair.getRight());
        }

    }

    @Override
    public String name() {
        return "Demonstration of the Observable.compose operator";
    }

    @Override
    public int chapter() {
        return 8;
    }

    @Override
    public void run() {
        Path path = Paths.get("src", "main", "resources", "letters.txt");
        Observable<?> indexedStrings = CreateObservable
                .fromViaUsing(path).compose(new OddFilter<String>());

        Helpers.subscribePrint(indexedStrings, "Indexed strings");
    }

    public static void main(String[] args) {
        new Compose().run();
    }

}