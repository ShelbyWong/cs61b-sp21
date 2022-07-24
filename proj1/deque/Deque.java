package deque;

import java.util.Iterator;

public interface Deque<T> {
    void printDeque();
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    T removeFirst();
    T removeLast();
    T get(int index);
    Iterator<T> iterator();
    boolean equals(Object o);

}
