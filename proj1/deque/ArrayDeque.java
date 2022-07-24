package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
    private class DequeIterator<T> implements  Iterator<T>{
        private int pos;

        public DequeIterator (){
            pos=front;
        }

        @Override
        public boolean hasNext() {
            return pos!=end;
        }

        @Override
        public T next() {
            T res= (T) items[pos];
            pos=(pos+1+items.length)%items.length;
            return res;
        }
    }

    private T[] items;
    private int size;
    private int front;
    private int end;

    public ArrayDeque() {
        items= (T[])new Object[8];
        end=front=items.length/2;
        size=0;
    }

    public ArrayDeque(int size){
        items= (T[])new Object[size];
        end=front=items.length/2;
        this.size=0;
    }

    //constant time
    @Override
    public void addFirst(T item) {
        if (size==items.length){
            resize((int) (size*1.5));
        }

        front=(front-1+items.length)%items.length;
        items[front]=item;
        size++;
    }

    public void resize(int size){
        T[] a = (T[]) new Object[size];
        //reduce size
        if (this.size>size) {
            if (front < end) {
                System.arraycopy(items, front, a, front, size);
            } else {
                int i = front + size - items.length;
                int j = front;
                int tmp=this.size;
                while (tmp > 0) {
                    a[i] = items[j];
                    i = (i + 1) % a.length;
                    j = (j + 1) % items.length;
                    tmp--;
                }
            }
        }

        //expand the size
        else{
            if (front<end){
                System.arraycopy(items,front,a,front,size);
                //There is no need to modify front and end index
            }else {
                int i=front+size- items.length;
                int j=front;
                while (this.size>0){
                    a[i]=items[j];
                    i=(i+1)%a.length;
                    j=(j+1)%items.length;
                    this.size--;
                }


            }

        }
        items = a;

    }

    //constant time,except array resizing
    @Override
    public void addLast(T item) {
        //resizing
        if (size==items.length){
            resize((int) (size*1.5));
        }
        items[end]=item;
        end=(end+1+items.length)%items.length;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size==0)return null;
        int index=front;
        size--;
        front=(front+1)%items.length;
        return items[index];
    }

    @Override
    public T removeLast() {
        if (size==0)return null;
        int index=end;
        size--;
        end=(end-1)% items.length;
        return items[index];
    }

    /**
     *
     * @param index: 0 is the front, 1 is the next item, and so forth
     * @return
     */
    @Override
    public T get(int index) {
        if (index<0||index>items.length)return null;

        return items[(front+index)% items.length];
    }

    @Override
    public void printDeque() {
        System.out.print("{");
        Iterator<T> tDequeIterator = iterator();
        while ((tDequeIterator.hasNext())){
            System.out.print(tDequeIterator.next()+",");
        }
        System.out.println("}");
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator<T>();
    }
}
