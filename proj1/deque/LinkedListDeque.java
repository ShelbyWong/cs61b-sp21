package deque;

import java.util.Iterator;


public class LinkedListDeque<T> implements Deque<T>{


    //node class doesn't access any method of LinkedListDeque
    private static class Node<T>{
        //For private nested classes, access modifiers are irrelevant
        T item;
        Node<T> next;
        Node<T> pre;

        public Node() {
            T item=null;
            next=null;
            pre=null;
        }

        public Node(T item) {
            this.item = item;
        }
    }

    private  class LinkedDequeIterator<T> implements Iterator<T>{
        Node<T> cur;

        public LinkedDequeIterator() {
            cur = (Node<T>) sentinel;
        }

        @Override
        public boolean hasNext() {

            return cur.next != null;
        }

        @Override
        public T next() {
            cur=cur.next;
            return cur.item;
        }
    }

    private int size;
    private Node<T> sentinel;

    public LinkedListDeque() {
        size=0;
        sentinel=new Node<T>();//head node
        sentinel.next=null;
        sentinel.pre=null;
    }

    @Override
    public void printDeque() {
        int count=0;
        Iterator<T> iterator = iterator();
        System.out.print("{");
        while (iterator.hasNext()){
            if (count++==size)break;
            System.out.print(iterator.next()+",");
        }
        System.out.print("}");
    }

    @Override
    public void addFirst(T item) {
        Node<T> tNode = new Node<>(item);
//base case: no node in deque
        if (sentinel.next==null){
            sentinel.next=tNode;
//            tNode.next=sentinel.next;
            tNode.pre=sentinel;
            sentinel.pre=tNode;
            size++;
            return;
        }
        //change the reference
        tNode.next=sentinel.next;
        sentinel.next.pre=tNode;
        sentinel.next=tNode;
        tNode.pre=sentinel;
        sentinel.pre.next=tNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> tNode = new Node<>(item);
        //base case: no node in deque
    if (sentinel.next==null){
        sentinel.next=tNode;
        sentinel.pre=tNode;
        tNode.pre=sentinel;
        size++;
        return;
    }
    //change the reference
        tNode.pre=sentinel.pre;
        sentinel.pre.next=tNode;
        sentinel.pre=tNode;
        tNode.next=sentinel.next;
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
        if (sentinel.next==null)return null;
        Node<T> tNode = sentinel.next;
        //base case:only one node is in the deque
        if (sentinel.pre==sentinel.next){
            sentinel.next=null;
            sentinel.pre=null;
            size--;
            return tNode.item;
        }
        sentinel.next=tNode.next;
        tNode.pre=sentinel;
        size--;
        return tNode.item;
    }

    @Override
    public T removeLast() {
        if (sentinel.pre==null)return null;
        Node<T> tNode=sentinel.pre;
        //base case:only one node is in the deque
        if (sentinel.pre==sentinel.next){
            sentinel.next=null;
            sentinel.pre=null;
            size--;
            return tNode.item;
        }
        tNode.pre.next=sentinel.next;
        sentinel.pre=tNode.pre;
        tNode.pre=null;
        size--;
        return tNode.item;
    }
    @Override
    public T get(int index) {
        Node<T> tNode=sentinel.next;
        int tmp=1;
        while (tNode!=null&&tmp!=index){
            tNode=tNode.next;
            tmp++;
        }
        if (tNode==null){
            System.out.println("null pointer");
            return null;
        }
        return tNode.item;
    }
    @Override
    public Iterator<T> iterator() {
        return new LinkedDequeIterator<>();
    }
    

}