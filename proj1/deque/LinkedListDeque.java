package deque;

import java.util.Iterator;

//Need to make <Item> to allow generic types to be created
public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{

    //Make nested private class to create abstraction from the user, prevents it from being manipulated
    //directly. Should be called each time insert item
    private class ListNode {
        // specify type <Item> as a private class
        private T item;
        private ListNode next;
        private ListNode prev;

        //Constructor for our private List node
        private ListNode(T i, ListNode n, ListNode p) {
            item = i;
            next = n;
            prev = p;
        }

    }

    // By convention, we have our declarations under the private class
    private int size;
    private T[] items;

    //Using circular sentinel, so I do not need a pointer for the first and last value, as the sentinel
    // will be keeping track of both of them.
    private ListNode sentinel;
    /**
     * Creates an empty list -- constructor with sentinel
     */
    public LinkedListDeque() {
        size = 0;
        //Create a sentinel so that we do not need to implement a specific case for the first element of the list
        sentinel = new ListNode (null, null, null);

        //Implementing cyclical sentinel node so that it points to itself as the end of the list
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Helper function for getRecursive function */
    private T recursiveFind(int start, int index, ListNode current) {
        //returns the current item when we reach the desired node index
        if (start == index) {
            return current.item;
        }
        return recursiveFind(start + 1, index, current.next);
    }
    //Helper method for removeLast()
    private T getFirst() {
        return sentinel.next.item;
    }

    //Helper method for removeFirst()
    private T getLast() {
        return sentinel.prev.item;
    }

    @Override
    public void addFirst(T x) {
        // Instantiate the new first node and put it at the front of the list
        ListNode first = new ListNode(x, sentinel.next, sentinel);

        //Now handling switching the pointers for the previous first
        sentinel.next.prev = first;
        sentinel.next = first;
        size = size + 1;
    }
    @Override
    public void addLast(T x) {
        //Create a new last value that will point to the sentinel node
        ListNode last = new ListNode(x, sentinel, sentinel.prev);

        //Now handling switching the pointers for the previous last node
        sentinel.prev.next = last;
        sentinel.prev = last;

        size = size + 1;
    }

    @Override
    public void printDeque() {
        ListNode temp = sentinel.next;

        while (temp != sentinel){
            System.out.println(temp.item.toString() + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque
     */
    @Override
    public T removeFirst() {

        //Checks size to see if sentinel is currently pointing to itself.
        if (size > 0){

            T firstItem = getFirst();
            //Removes the pointer from the first element to the sentinel
            sentinel.next.prev = null;

            //Make the second element now point back to the sentinel
            sentinel.next.next.prev = sentinel;

            //The second element not becomes the first
            sentinel.next = sentinel.next.next;

            size = size - 1;

            return firstItem;
        }

        return null;
    }

    /**
     * Removes and returns the item in the back of the deque
     */
    @Override
    public T removeLast() {
        //Checks size to see if sentinel is currently pointing to itself.
        if (size > 0){

            T lastItem = getLast();
            //Change the last element's next to point to null
            sentinel.prev.next = null;

            //Make the new last element point to the sentinel
            sentinel.prev = sentinel.prev.prev;

            size = size - 1;

            return lastItem;
        }

        return null;

    }

    /**
     * Public getter used to return the size, as it is private to prevent direct manipulation
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0){
            System.out.println("Index out of bounds");
            return null;
        }

        ListNode temp = sentinel.next;
        int count = 0;

        while (temp != sentinel) {
            if (count == index) {
                return temp.item;
            }
            //Goes to next node and increase count until index
            temp = temp.next;
            count = count + 1;
        }

        return null;
    }

    @Override
    public boolean equals(Object obj){
        //This checks if the object is compared with itself
        if (obj ==  this) {
            return true;
        }
        //Checks to see if the object being passed if of type deque
        if (!(obj instanceof Deque)){
            return false;
        }
        //Declare a new variable and Typecast object to a deque
        Deque o = (Deque) obj;

        if (this.size() != o.size()){
            return false;
        }
        for (int i = 0; i < size; i++){
            //Checks if the objects return the same node and node vals equal
            if (this.get(i) != o.get(i) && !this.get(i).equals(o.get(i))){
                return false;
            }

        }
        return true;
    }

    public T getRecursive(int index){
        if (index >= size || index < 0){
            System.out.println("Index out of bounds");
            return null;
        }
        else {
            ListNode temp = sentinel.next;
            T item = recursiveFind(0, index, temp);
            return item;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private ListNode pointer;

        LinkedListIterator() {
            pointer = sentinel;
        }
        public boolean hasNext() {
            return pointer.next != null && pointer.next != sentinel;
        }

        public T next() {
            pointer = pointer.next;
            return pointer.item;
        }
    }


}
