package deque;

public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item x);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public int get(int index);

    //TODO: Add in the iterator method

    public boolean equals(Object o);

}
