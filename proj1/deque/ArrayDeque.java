package deque;

public class ArrayDeque<T> implements Deque<T> {

    //Setting our necessary private variables
    //Design pattern to stop users from being able to directly manipulate these, they should
    //Only be able to manipulate these using the methods we give them
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        //Generic arrays are not allowed!!!
        //We need this syntax to typecast our Object array as an array of type Item
        items = (T[]) new Object[8];
        size = 0;
        //Make the front of the array -1, when an element is inserts in the front we increment by 1
        int nextFirst = items.length - 1;
        int nextLast = 0;

    }
    @Override
    public int size(){
        return size;
    }


    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        /**
         * Copy from nextFirst until we hit the end of the array
         * Upon hitting the end of the array, we will then go to the
         * First index and go until nextLast
         */

        if (nextFirst < nextLast - 1 || nextFirst == items.length - 1) {
            if (nextFirst == items.length - 1){
                nextFirst = -1;
            }

            System.arraycopy(items, nextFirst + 1, newItems, 0, size);

        }
        else {
            System.arraycopy(items, nextFirst + 1, newItems, 0, items.length - 1 - nextFirst);
            System.arraycopy(items, 0, newItems, items.length - 1 - nextFirst, nextLast);
        }

        nextLast = size;
        nextFirst = newItems.length - 1;
        items = newItems;
    }

    @Override
    public void addFirst(T item){

        if (size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = item;

        if (nextFirst == 0){
            nextLast = items.length;
        }
        else {
            nextFirst = nextFirst - 1;
        }

        size = size + 1;

    }
    @Override
    public void addLast(T item) {
        if (size == items.length){
            resize(size * 2);
        }

        items[nextLast] = item;
        if (nextLast == items.length){
            nextLast = 0;
        }
        else {
            nextLast = nextLast + 1;
        }
        size = size + 1;
    }
    @Override
    public T get(int index){
        if (index < 0 || index >= size){
            //Throwing error for out of bounds index
            throw new Error("Index out of bounds");
        }
        if (nextFirst + 1 + index < items.length){
            return items[nextFirst + 1 + index];
        }
        else {
            index = index - items.length + nextFirst + 1;
            return items[index];
        }
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size - 1 < items.length / 4 && items.length > 16){
            resize(size / 2);
        }

        if (nextFirst + 1 > items.length - 1){
            nextFirst = 0;
        }
        else {
            nextFirst = nextFirst + 1;
        }

        T removed = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;

        return removed;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size - 1 < items.length / 4 && items.length > 16){
            resize(size / 2);
        }
        if (nextLast - 1 < 0) {
            nextFirst = items.length;
        }
        else {
            nextLast = nextLast - 1;
        }

        T removed = items[nextLast];
        items[nextLast] = null;
        size = size - 1;

        return removed;
    }

    @Override
    public void printDeque() {
        int index = nextFirst - 1;

    }

}