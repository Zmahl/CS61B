package hashmap;

import com.sun.jdi.Value;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;



/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */

    private static final int INIT_CAPACITY = 16;
    private static double INIT_LOAD = 0.75;

    private int m;
    private double loadFactor;
    private int n;



    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        this(INIT_CAPACITY, INIT_LOAD);

    }

    public MyHashMap(int initialSize) {
        //This() calls the constructor (int initialSize, double maxLoad)
        this(initialSize, INIT_LOAD);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        this.m = initialSize;
        this.loadFactor = maxLoad;
        n = 0;
        //We have to use collection here so that it can be casted with ArrayList, LinkedList, etc.
        buckets = new Collection[initialSize];

        for (int i = 0; i < initialSize; i++) {
            buckets[i] = createBucket();
        }
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return null;
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        //I am going to create a bucket of linked lists, therefore my buckets are linked lists
        return new LinkedList<>();

    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        return null;
    }

    /**
     * Returns index where the key should be placed in relation to it's hash value
     * @param key
     * @return
     */
    private int determineBucket(K key) {
        return Math.floorMod(key.hashCode(), buckets.length);
    }

    private void resize(int size) {

    }

    /**
     * Method that will check over the existing keys within the hashmap and return the Node
     * @param key
     * @return
     */
    private Node getNode(K key) {
        if (n == 0) {
            return null;
        }

        int index = determineBucket(key);
        //Now use the for each loop to interact with the buckets
        for (Node n : buckets[index]) {
            if (n.key.equals(key)){
                return n;
            }
        }
        return null;
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        //This will clear each entry from the linked list
        buckets = null;
        n = 0;
        loadFactor = 0;
    };

    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        if (key == null) {
            throw new IllegalArgumentException("Invalid key provided");
        }

        Set<K> findKey = keySet();

        return findKey.contains(key);
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Invalid key provided");
        }

        Node n = getNode(key);

        if (n == null){
            return null;
        }

        return n.value;
    }

    /** Returns the number of key-value mappings in this map. */
    public int size(){
        throw new UnsupportedOperationException();
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    public void put(K key, V value) {
        Node node = getNode(key);
        //Check if the node exists, then if it does change the current value
        if (node != null) {
            node.value = value;
        }

        else {
            int index = determineBucket(key);
            buckets[index].add(createNode(key, value));
            n = n + 1;

            /*double currLoad = n / m;

            if (currLoad >= loadFactor){
            resize(m);
            }*/
        }

    }

    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet(){
        Set<K> set = new HashSet<>();
        for (Collection<Node> items : buckets) {
            for (Node node : items) {
                set.add(node.key);
            }
        }
        return set;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */

    public V remove(K key){
        if (key == null) {
            throw new IllegalArgumentException("Invalid key provided");
        }

        throw new UnsupportedOperationException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    //This method does not need to be implemented
    public V remove(K key, V value){
        if (key == null) {
            throw new IllegalArgumentException("Invalid key provided");
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return new HashMapIter();
    }

    private class HashMapIter implements Iterator<K> {
        private int index;

        HashMapIter(){
            index = 0;
        }

        @Override
        public boolean hasNext(){ return false; }

        @Override
        public K next() { return null; }

    }
}
