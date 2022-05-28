package deque;

public class ArrayDeque<Item> implements Deque<Item>{

    //Setting our necessary private variables
    //Design pattern to stop users from being able to directly manipulate these, they should
    //Only be able to manipulate these using the methods we give them
    private int length;
    private Item[] items;
    private int front;
    private int rear;
    private int size;

    public ArrayDeque() {
        //Generic arrays are not allowed!!!
        //We need this syntax to typecast our Object array as an array of type Item
        items = (Item[]) new Object[8];
        size = 0;
        //Make the front of the array -1, when an element is inserts in the front we increment by 1
        front = -1;
        //Set the rear to the first index
        rear = 0;

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
    private boolean isFull() {
        //The front will be going from the back of the array, and the read will be going from the front
        return ((front == 0 && rear == size-1) || front == rear + 1);

    }

    public void addFirst (Item item){
        if (isEmpty()){
            //After changing to 0, now array will be recognized as not empty
            front = 0;
            rear = 0;
        }
        //Front will be coming from the back of the underlying array
        else if (front == 0){
            front = size - 1;
        }

        else {
            //Because front is going from the end of the array to the beginning, will decrement after inserting
            front = front - 1;

        }
        //Set index = to item value being passed in
        items[front] = item;

        size = size + 1;

    }

    public void addLast (Item item) {

        //Check if the array is empty
        if (front == -1){
            front = 0;
            rear = 0;
        }
        //Check to see if rear is at the end of the array, if so set it equal to the first index
        else if (rear == size - 1){
            rear = 0;
        }

        else {
            rear = rear + 1;
        }
        items[rear] = item;

        size = size + 1;
    }

    public boolean isEmpty() {
        return (front == -1);
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

    /**
     * Pops the first item, sets the index to null and decrements front
     * @return item at the last index
     */
    public Item removeFirst() {

        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        //Create a variable to hold the value at the index, then set to null
        Item returnItem = items[front];
        items[front] = null;

        if ((size < items.length / 4) && (size >= 16)) {
            resize(items.length / 4);
            System.out.println("full");
        }
        //This will check if there is only 1 element in the array. This is NOT when it is full
        if (front == rear){
            front = -1;
            rear = -1;
        }
        else {
            front = front + 1;
        }
        size = size - 1;
        return returnItem;

    }

    /**
     * Removes and returns the last item in the array, setting it to null and incrementing rear
     * @return the last Item in the array
     */
    public Item removeLast() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        Item returnItem = items[rear];
        //Reinitialize start values if there is only 1 element currently in the array
        if (front == rear){
            front = -1;
            rear = -1;
        }
        else if (rear == 0){
            rear = size - 1;
        }
        else {
            rear = rear - 1;
        }
        size = size - 1;
        return returnItem;
    }

    public Item getLast() {
        if (isEmpty()){
            return null;
        }
        return items[rear];
    }

    public Item getFirst() {
        if (isEmpty()){
            return null;
        }
        return items[front];
    }

    public Item get(int index) {
        return items[index];
    }



}