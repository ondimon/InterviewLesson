package linkedlist;

import list.DirectionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDirectionalList<T> implements DirectionalList<T> {
    private int size;
    private Node first;
    private Node last;

    public TwoDirectionalList() {

    }

    public TwoDirectionalList(T[] array) {
        for(T val : array) {
            add(val);
        }
    }

    @Override
    public void add(T val) {
        if (last == null) {
            last = new Node(val, null, null);
            first = last;
        }else{
            Node newLast = new Node(val, last, null);
            last.setNext(newLast);
            last = newLast;
        }
        size++;
    }

    @Override
    public boolean remove(T val) {
        if(first == null) {
            return false;
        }

        for(Node i = first; i != null; i = i.getNext()) {
            if(i.getVal().equals(val)) {
                unlink(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T getFirst() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        return first.getVal();
    }

    @Override
    public T getLast() {
        if(last == null) {
            throw new NoSuchElementException();
        }
        return last.getVal();
    }

    @Override
    public T get(int i) {
       if (i > size - 1 || i < 0) {
           throw new IndexOutOfBoundsException();
       }
       Node result;
       if (i < size / 2) {
           int counter = 0;
           result = first;
           if (counter != i) {
               result = result.getNext();
               counter ++;
           }
       } else {
           int counter = size - 1;
           result = last;
           if (counter != i) {
               result = result.getPrev();
               counter --;
           }

       }
       return result.getVal();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T val) {
        int index = 0;
        for(Node i = first; i != null; i = i.getNext()) {
            if(i.getVal().equals(val)) {
                return index;
            }
            index ++;
        }
        throw new NoSuchElementException();
    }

    private void unlink(Node item) {
        Node next = item.getNext();
        Node prev = item.getPrev();

        if(next == null) {
            last = prev;
        }else{
            next.setPrev(prev);
        }

        if(prev == null) {
            first = next;
        }else{
            prev.setNext(next);
        }

        size --;

    }

    @Override
    public Iterator<T> iterator() {
        return new IterNode(first);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<T> it = this.iterator();
        while(it.hasNext()) {
            sb.append(it.next());
            if(it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node  {
        private T val;
        private Node next;
        private Node prev;

        private Node(T val, Node prev, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        private T getVal() {
            return val;
        }

        private Node getNext() {
            return next;
        }

        private Node getPrev() {
            return prev;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private void setPrev(Node prev) {
            this.prev = prev;
        }

    }

    private class IterNode implements Iterator<T> {
        private Node node;

        public IterNode(Node node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T val = node.getVal();
            node = node.getNext();
            return val;
        }
    }
}
