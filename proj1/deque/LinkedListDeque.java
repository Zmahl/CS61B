package deque;

public class LinkedListDeque<T> implements Deque<T>{

    private class Node {
        private T item;
        private Node next;
        private Node prev;


        private Node(T item, Node next, Node prev){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, sentinel, sentinel);
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        //Create a new node
        Node first = new Node(item, sentinel.next, sentinel);

        sentinel.next.prev = first;
        sentinel.next = first;

        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node last = new Node(item, sentinel, sentinel.prev);

        sentinel.prev.next = last;
        sentinel.prev = last;

        size += 1;
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
        Node p = sentinel.next;
        //Get item
        T removed = p.item;
        //Change sentinel next to second element
        sentinel.next = p.next;
        //Change p
        p.next.prev = sentinel;
        //Remove pointers for garbage collector
        p.next = null;
        p.prev = null;

        return removed;
    }

    @Override
    public T removeLast() {
        Node p = sentinel.prev;

        T removed = p.item;

        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        p.next = null;
        p.prev = null;

        return removed;
    }

    @Override
    public T get(int index) {
        Node p = sentinel;
        int counter = 0;

        while (counter < index && p != null){
            p = p.next;
            counter += 1;
        }

        if (counter == index){
            return p.item;
        }

        else {
            return null;
        }
    }

    public void printDeque() {
        Node p = sentinel.next;

        while(p != sentinel) {
            System.out.println(p.item);
        }
    }

}
