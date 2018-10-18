package chapter3;

import common.Program;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class ReactiveSumV3 implements Program {

    public static class ReactiveSum {
        private BehaviorSubject<Double> a = BehaviorSubject.create(0.0);
        private BehaviorSubject<Double> b = BehaviorSubject.create(0.0);
        private BehaviorSubject<Double> c = BehaviorSubject.create(0.0);

        public ReactiveSum() {
            Observable.combineLatest(a, b, (x, y) -> x + y).subscribe(c);
        }

        public double getA() {
            return a.getValue();
        }

        public void setA(double a) {
            this.a.onNext(a);
        }

        public Observable<Double> obsA() {
            return a.asObservable();
        }

        public double getB() {
            return b.getValue();
        }

        public void setB(double b) {
            this.b.onNext(b);
        }

        public Observable<Double> obsB() {
            return b.asObservable();
        }

        public double getC() {
            return c.getValue();
        }

        public Observable<Double> obsC() {
            return c.asObservable();
        }

    }

    @Override
    public String name() {
        return "Reactive Sum, version 3 (with Subjects)";
    }

    @Override
    public int chapter() {
        return 3;
    }

    @Override
    public void run() {
        ReactiveSum sum = new ReactiveSum();

        subscribePrint(sum.obsC(), "Sum");
        sum.setA(5);
        sum.setB(4);
    }

    public static void main(String[] args) {
        new ReactiveSumV3().run();
    }

}
