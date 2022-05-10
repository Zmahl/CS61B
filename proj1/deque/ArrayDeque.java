package deque;

public class ArrayDeque<Item> {

    //Setting our necessary private variables
    //Design pattern to stop users from being able to directly manipulate these, they should
    //Only be able to manipulate these using the methods we give them
    private int size;
    private Item[] items;
    private int head;
    private int tail;


    //Creating the constructor for the ArrayList
    public ArrayDeque() {
        //Generic arrays are not allowed!!!
        //We need this syntax to typecast our Object array as an array of type Item
        items = (Item[]) new Object[8];
        size = 0;
        //Make the front of the array -1, when an element is inserts in the front we increment by 1
        head = -1;
        //Set the tail to the first index
        tail = 0;
    }

    /**
     * Resize array based on the capacity
     * @param capacity
     */
    private void resize(int capacity) {
        //Create a new generic array to copy all values currently in item with new size [capacity]
        Item[] a = (Item[]) new Object[capacity];
        //Loop through items and copy the values into a
        System.arraycopy(items, 0, a, 0, size);
        //Set items equal to the new copied array with the new size of a
        items = a;
    }


    /**
     * Function will check if queue is currently full
     */
    private boolean isArrayFull() {
        if (size == items.length){
            return true;
        }

        return false;

    }

    public void addFirst (Item item){

        size = size + 1;
        //If items array is full, call resize and double the capacity of the array
        if (isArrayFull()) {

            resize(size * 2);
        }

        //Now check if the queue is empty
        if (head == -1){
            head = 0;
            tail = 0;
        }

        //Implementing a circular array based on geeksforgeeks?
        else if (head == 0){
            head = size - 1;
        }


    }

    public void addLast (Item item) {

        //If items array is full, call resize and double the capacity of the array
        if (isArrayFull()) {
            resize(size * 2);
        }

        //size - 1 is always the current last item in the array, so we set the next item in array
        //using the current size as the index to set the value
        items[size] = item;
        size = size + 1;

        //Pointer to the tail end of the array
        tail = (tail + 1) % items.length;


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

        if ((size < items.length / 4) && (size > 8)) {
            resize(items.length / 4);
        }
        Item returnItem = getFirst();
        size = size - 1;

        return returnItem;

    }

    public Item getLast() {
        return items[size - 1];
    }

    public Item getFirst() {
        return items[0];
    }

    //Removes and returns the last item
    public Item removeLast() {
        //Use getLast as helper
        Item returnItem = getLast();
        //Set last element equal to null to save space for array implementation
        items[size - 1] = null;
        //Hide object in the array instead of deleting it from the array
        size = size - 1;

        //We are setting a condition to resize the array when it drops to 25% capacity
        if ((size < items.length / 4) && (size > 8)) {
            resize(items.length / 4);
        }

        return returnItem;

    }

    public Item get(int index) {
        return items[index];
    }



}
