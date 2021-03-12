package arraylist;

import list.List;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    static final int CAPACITY = 10;
    private T[] array;
    private int size = 0;

    public ArrayList() {
        this.array = (T[])new Object[CAPACITY];
    }

    @Override
    public void add(T val) {
        if (array.length < size + 1) {
            this.array = Arrays.copyOf(this.array, array.length + CAPACITY);
        }
        array[size] = val;
        size ++;
    }

    @Override
    public boolean remove(T val) {
        int index = indexOf(val);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size --;
        return true;
    }

    @Override
    public T get(int i) {
        if (i > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T val) {
        int index = 0;
        for(T element : array) {
            if(element.equals(val)) {
                return index;
            }
            index ++;
        }
        throw new NoSuchElementException();
    }


}
