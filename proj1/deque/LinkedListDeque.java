package deque;
import afu.org.checkerframework.checker.javari.qual.ThisMutable;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>,Iterable<T>{
    private  int size;
    private Node<T> sentinel;

    public LinkedListDeque() {
        size=0;
        sentinel=new Node<T>();
        sentinel.pre=sentinel;
        sentinel.next=sentinel;
    }

    private static class  Node<T>{
        T data;
        Node<T> next;
        Node<T> pre;
        public Node() {
            data = null;
            next = null;
            pre = null;
        }

        public Node(T info) {
            this.data = info;
            next = null;
            pre = null;
        }
    }
    private class LLDIterator implements Iterator<T>{
        Node<T> index;

        public LLDIterator() {
            this.index = sentinel;
        }

        @Override
        public boolean hasNext() {
            return index.next != sentinel;
        }

        @Override
        public T next() {
            index = index.next;
            return index.data;
        }
    }

    @Override
    public void printDeque() {
        Iterator<T> iterator = iterator();
        System.out.print("{");
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
        System.out.print("}");
    }


    @Override
    public void addFirst(T item) {
        Node<T> tNode = new Node<>(item);
        tNode.next=sentinel.next;
        tNode.pre=sentinel;
        sentinel.next.pre=tNode;
        sentinel.next=tNode;
        size+=1;
    }

    @Override
    public void addLast(T item) {
        Node<T> tNode = new Node<>(item);
        tNode.next = sentinel;
        tNode.pre =  sentinel.pre;
        sentinel.pre.next= tNode;
        sentinel.pre=tNode;
        size+=1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size==0)return null;
        Node<T> tNode= sentinel.next;
        sentinel.next=tNode.next;
        tNode.next.pre=sentinel;
        size-=1;
        return tNode.data;
    }

    @Override
    public T removeLast() {
        if (size == 0)return null;
        Node<T> tNode=sentinel.pre;
        tNode.pre.next=sentinel.next;
        sentinel.pre=tNode.pre;
        size-=1;
        return tNode.data;
    }

    @Override
    public T get(int index) {
        if (index<0)return null;
        Node<T> p=sentinel.next;
        while (p!=sentinel&&index>0){
            p=p.next;
            index-=1;
        }
        return p.data;
    }

    @Override
    public Iterator<T> iterator() {
        return  new LLDIterator();
    }

    @Override
    public boolean equals(Object o){
        if (o==null)return false;
        else if (o==this)return true;
        else if (!(o instanceof LinkedListDeque))return false;

        LinkedListDeque<T> lld = (LinkedListDeque<T>) o;
        if (lld.size()!=this.size)return false;
        for (int i = 0; i < size; i++) {
            if (!lld.get(i).equals(this.get(i)))return false;
        }
        return true;
    }
    public T getRecursive(int index){
        if (index<0||index>size-1) {
            return null;
        }
        return getRecursiveHelper(index,sentinel.next);
    }
    public T getRecursiveHelper(int index,Node<T> cur){
        if (cur == sentinel){
            return null;
        }
        if (index==0) {
            return cur.data;
        }
        return getRecursiveHelper(index-1,cur.next);
    }
}