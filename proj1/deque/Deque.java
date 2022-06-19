package deque;

public interface Deque<T> {
    void addFirst(T x);
    void addLast(T x);
    //Creating a default implementation in isEmpty deque
    default boolean isEmpty() {
        return size() == 0;
    };
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
