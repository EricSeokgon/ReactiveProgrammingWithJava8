package common.checked;

public interface CheckedAction1<T> {
    void call(T arg) throws Exception;
}