package deque;

public class ArrayDeque<T> implements Deque<T>{

    private T[] items;
    private int size;
    //Pointer to next empty spot front
    private int front;
    //Pointer to next empty spot back
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 4;
        back = 5;
    }


    public void addFirst(T item){
        items[front] = item;
        front = front - 1;

        if (front == 0) {
            front = items.length - 1;
        }
        size += 1;
    }

    public void addLast(T item){
        items[back] = item;
        back = back + 1;

        if (back == items.length - 1){
            back = 0;
        }
        size = size + 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public T removeFirst() {
        front = front + 1;

        if (front == items.length - 1){
            front = 0;
        }
        T removed = items[front];
        items[front] = null;
        size = size - 1;

        return removed;
    }

    public T removeLast() {
        back = back - 1;

        if (back == 0){
            back = items.length;
        }
        T removed = items[back];
        items[back] = null;
        size = size - 1;

        return removed;
    }

    public T get(int index){
        int adjustIndex = (index + front - 1) % items.length;

        return items[adjustIndex];
    }
}
