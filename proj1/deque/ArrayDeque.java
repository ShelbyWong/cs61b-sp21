package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>,Iterable<T>{
    @SuppressWarnings("unchecked")
    private T items[] = (T[]) new Object[8];
    private int size;
    private int nextFirst;
    private int nextLast;
    private class ADIterator implements Iterator<T>{
        private int pointer=(nextFirst+1)%items.length;

        @Override
        public boolean hasNext() {
            return size>0;
        }

        @Override
        public T next() {
            System.out.print(items[pointer]);
            pointer=(pointer+1)%items.length;
            return null;
        }
    }

    public ArrayDeque() {
        int size = 0;
        nextFirst=items.length/2;
        nextLast=items.length/2+1;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public void addFirst(T item) {
        if (size== items.length){
            resize((int)(size*1.5));
        }
        items[nextFirst]=item;
        size+=1;
        nextFirst=(nextFirst-1+ items.length)% items.length;

    }
    @Override
    public void addLast(T item) {
        if (size== items.length){
            resize((int)(size*1.5));
        }
        items[nextLast]=item;
        size++;
        nextLast=(nextLast+1+ items.length)% items.length;
    }

    public void resize(int newSize){
        T[] a = (T[])new Object[newSize];
        int i=0;
        int j=(nextFirst+1)%items.length;

        int tmp=size;
        if (newSize>size){
            while (tmp>0){
                a[i]=items[j];
                j=(j+1)%items.length;
                i+=1;
                tmp--;
            }
        }
        nextFirst=a.length-1;
        nextLast=size;
        items=a;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())return null;
        nextFirst=(nextFirst+1)% items.length;
        T item=items[nextFirst];
        size--;
        return item;
    }

    @Override
    public T removeLast() {
        if(isEmpty())return null;
        nextLast=(nextLast-1)% items.length;
        T item=items[nextLast];
        size--;
        return item;
    }

    @Override
    public T get(int index) {
        if (index>size-1||index<0)return null;
        int relativeIndex=(nextFirst+1+index)% items.length;
        return items[relativeIndex];
    }

    @Override
    public Iterator<T> iterator() {
        return new ADIterator();
    }

    @Override
    public boolean equals(Object o){
        if (o==null)return false;
        if (o==this)return false;
        if (!(o instanceof ArrayDeque))return false;
        ArrayDeque<T> ad = (ArrayDeque<T>) o;
        if (ad.size()!=size)return false;
        for (int i = 0; i < size; i++) {
            if (ad.get(i)!=get(i))return false;
        }
        return true;
    }
}
