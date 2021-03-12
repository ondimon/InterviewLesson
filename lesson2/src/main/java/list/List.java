package list;

public interface List<T> {
    void add(T val);
    boolean remove(T val);
    T get(int i);
    int size();
    int indexOf(T val);
}
