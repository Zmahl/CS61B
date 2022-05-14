package deque;

public class ArrayDeque<Item> implements Deque<Item> {

    //Setting our necessary private variables
    //Design pattern to stop users from being able to directly manipulate these, they should
    //Only be able to manipulate these using the methods we give them
    private int length;
    private Item[] items;
    private int front;
    private int rear;
    private int size;


    //Creating the constructor for the ArrayList
    public ArrayDeque() {
        //Generic arrays are not allowed!!!
        //We need this syntax to typecast our Object array as an array of type Item
        items = (Item[]) new Object[8];
        size = items.length;
        //Make the front of the array -1, when an element is inserts in the front we increment by 1
        front = -1;
        //Set the rear to the first index
        rear = 0;

        length = 0;
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

        //Now check if the queue is empty
        if (front == -1){
            //After changing to 0, now array will be recognized as not empty
            front = 0;
            rear = 0;
        }

        //Implementing a circular array based on geeksforgeeks
        else if (front == 0){
            front = size - 1;
        }

        else {
            //Because front is going from the end of the array to the beginning, will decrement after inserting
            front = front - 1;

        }
        //Set index = to item value being passed in
        items[front] = item;

        length = length + 1;

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

        length = length + 1;
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public int size() {
        return length;
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

        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        Item returnItem = items[front];

        if ((length < items.length / 4) && (size > 8)) {
            resize(items.length / 4);
            System.out.println("full");
            return null;
        }

        //This will check if there is only 1 element in the array. This is NOT when it is full
        if (front == rear){
            front = -1;
            rear = -1;
        }

        else {
            //Otherwise, just move up the front pointer
            front = front + 1;
        }
        length = length - 1;
        return returnItem;

    }

    //Removes and returns the last item
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
        length = length - 1;
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
