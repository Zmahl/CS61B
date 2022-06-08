package deque;

import java.util.Iterator;
public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item x);
    //Creating a default implementation in isEmpty deque
    default boolean isEmpty() {
        return this.size() == 0;
    };
    public int size();
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);

    /**Returns whether or not the parameter o is equal ot the Deque
     * it will be considered equal if it is a Deque and it contains the same contents
     * @param o
     * @return
     */



    public boolean equals(Object o);


}
