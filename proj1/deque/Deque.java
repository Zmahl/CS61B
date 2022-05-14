package deque;

public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item x);
    public boolean isEmpty();
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
