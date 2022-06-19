package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int startIndex;
    private int endIndex;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        startIndex = 3;
        endIndex = 4;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */

    @Override
    public void addFirst(T item) {
        resize();
        items[startIndex--] = item;
    }

    /**
     * Adds an item of type T to the back of the deque
     */
    @Override
    public void addLast(T item) {
        resize();
        items[endIndex++] = item;
    }

    /**
     * Returns the number of items in the deque
     */
    @Override
    public int size() {
        return endIndex - startIndex - 1;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    @Override
    public void printDeque() {
        for (int i = startIndex + 1; i < endIndex; i++) {
            System.out.print(items[i].toString() + " ");
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (size() == 0) {
            return null;
        }
        T item = items[++startIndex];
        resize();
        return item;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        T item = items[--endIndex];
        resize();
        return item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     */
    @Override
    public T get(int index) {
        int size = size();
        if (index < 0 || index >= size) {
            return null;
        }
        return items[startIndex + index + 1];
    }

    /**
     * when factor is very low or very high,
     * build a new array and copy the items to the new array.
     */
    private void resize() {
        int length = items.length;
        int size = size();
        double factor = size / (length + 0.0);
        int newLength;
        if (factor < 0.25 && length > 16) {
            //make size of items small
            T[] newitems = (T[]) new Object[length / 2];
            cpitems(newitems);
            items = newitems;
        }
        if (factor >= 0.85) {
            //make size of items large
            T[] newitems = (T[]) new Object[length * 2];
            cpitems(newitems);
            items = newitems;
        }
        if (startIndex <= 0 || endIndex >= items.length - 1) {
            //when only addFirst or addLast
            T[] newitems = (T[]) new Object[length];
            cpitems(newitems);
            items = newitems;
        }
    }

    /**
     * build a new array and copy the items to the new array.
     */

    private void cpitems(T[] newitems) {
        int length = newitems.length;
        int index = startIndex + 1;
        int size = size();
        startIndex = (length - size()) / 2 - 1;
        for (int i = 0; i < size; ++i) {
            newitems[startIndex + i + 1] = items[index++];
        }
        endIndex = startIndex + size + 1;
    }


    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object obj) { 
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Deque)) {
            return false;
        }
        Deque o = (Deque) obj;
        if (o.size() != this.size()) {
            return false;
        }
        int size = this.size();
        for (int i = 0; i < size; ++i) {
            if (this.get(i) != o.get(i) && !this.get(i).equals(o.get(i))) {
                return false;
            }
        }
        return true;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        ArrayDequeIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            T returnItem = items[index];
            index += 1;
            return returnItem;
        }
    }
}