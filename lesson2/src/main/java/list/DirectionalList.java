package list;

public interface DirectionalList<T> extends Iterable<T>, List<T>{
    T getFirst();
    T getLast();
}
