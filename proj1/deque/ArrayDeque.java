package deque;

public class ArrayDeque<Item> {

    //Setting our necessary private variables
    //Design pattern to stop users from being able to directly manipulate these, they should
    //Only be able to manipulate these using the methods we give them
    private int size;
    private Item[] items;


    //Creating the constructor for the ArrayList
    public ArrayDeque() {
        //Generic arrays are not allowed!!!
        //We need this syntax to typecast our Object array as an array of type Item
        items = (Item[]) new Object[8];
        size = 0;
    }

    /**
     * Resize array based on the capacity
     * @param capacity
     */
    private void resize(int capacity) {
        //Create a new generic array to copy all values currently in item with new size [capacity]
        Item[] a = (Item[]) new Object[capacity];
        //Loop through items and copy the values into a
        for (int i = 0; i < capacity; i++){
            a[i] = items[i];
        }
        //Set items equal to the new copied array with the new size of a
        items = a;
    }

    public void addFirst (Item item){
        //If items array is full, call resize and double the capacity of the array
        if (size == items.length) {
            resize(size * 2);
        }

    }

    public void addLast (Item item) {
        //If items array is full, call resize and double the capacity of the array
        if (size == items.length) {
            resize(size * 2);
        }
        //size - 1 is always the current last item in the array, so we set the next item in array
        //using the current size as the index to set the value
        items[size] = item;
        size = size + 1;

    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    //Printing generic array in java using the method found here:
    //http://www.java2s.com/Tutorial/Java/0200__Generics/Usinggenericmethodstoprintarrayofdifferenttypes.htm

    public void printDeque() {
        int count = 0;
        for (Item element : items) {
            //checks to make sure that we do not go into "deleted" elements in the array
            if (count == size) {
                break;
            }
            //Convert the element to a string and print it
            System.out.printf("%s ", element);
            count = count + 1;
        }
        System.out.println();

    }
    //Removes and returns the first item
    public Item removeFirst() {
        return null;
    }

    public Item getLast() {
        return items[size - 1];
    }

    //Removes and returns the last item
    public Item removeLast() {
        //We are setting a condition to resize the array when it drops to 25% capacity
        if ((size < items.length / 4) && (size > 8)) {
            resize(items.length / 4);
        }
        //Use getLast as helper
        Item returnItem = getLast();
        items[size - 1] = null;
        //Hide object in the array instead of deleting it from the array
        size = size - 1;

        return returnItem;

    }

    public Item get(int index) {
        return items[index];
    }

}
