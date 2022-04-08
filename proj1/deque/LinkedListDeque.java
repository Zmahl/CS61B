package deque;

//Need to make <Item> to allow generic types to be created
public class LinkedListDeque<Item> {


    //Make nested private class to create abstraction from the user, prevents it from being manipulated
    //directly. Should be called each time insert item
    private class ListNode {
        // specify type <Item> as a private class
        private Item item;
        private ListNode next;
        private ListNode prev;

        //Constructor for our private List node
        private ListNode(Item i, ListNode n, ListNode p) {
            item = i;
            n = next;
            p = prev;

        }

    }
    // By convention, we have our declarations under the private class
    private int size;
    private Item[] items;
    private ListNode sentinel;

    /**
     * Creates an empty list
     */
    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode (null, null, null);

        //Implementing cyclical sentinel node so that it points to itself as the end of the list
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

    }

    public void addFirst(Item x) {

    }

    public void addLast(Item x) {

    }

    public boolean isEmpty() {
        if (size == 0) {
            return false;
        }

        return true;
    }

    public void printDeque() {

    }

    /**
     * Removes and returns the item at the front of the deque
     */
    public void removeFirst() {

        if (sentinel.next != null){
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
        }
    }

    /**
     * Removes and returns the item in the back of the deque
     */
    public void removeLast() {

    }

}
