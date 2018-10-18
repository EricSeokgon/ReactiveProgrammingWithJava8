package chapter4;

import common.CreateObservable;
import common.Program;
import rx.Observable;

import java.nio.file.Paths;

import static common.Helpers.subscribePrint;

public class FlatMapAndFiles implements Program {

    @Override
    public String name() {
        return "Working with files using flatMap";
    }

    @Override
    public int chapter() {
        return 4;
    }

    @Override
    public void run() {
        Observable<String> fsObs = CreateObservable.listFolder(
                Paths.get("src", "main", "resources"),
                "{lorem.txt,letters.txt}")
                .flatMap(path -> CreateObservable.from(path));

        subscribePrint(fsObs, "FS");
    }

    public static void main(String[] args) {
        new FlatMapAndFiles().run();
    }

}
