package deque;

import java.util.Iterator;
public interface Deque<T>{
    void addFirst(T x);
    void addLast(T x);
    //Creating a default implementation in isEmpty deque
    default boolean isEmpty() {
        return this.size() == 0;
    };
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);

    /**Returns whether or not the parameter o is equal ot the Deque
     * it will be considered equal if it is a Deque and it contains the same contents
     * @param
     * @return
     */

    boolean equals(Object o);


}
