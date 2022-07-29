package hashmap;

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

    private int initialSize;
    private double loadFactor;
    private HashSet<K> keyHolder;
    private int numberKeys;

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
        this(16, 0.75);

    }

    public MyHashMap(int initialSize) {
        //This() calls the constructor (int initialSize, double maxLoad)
        this(initialSize, 0.75);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        this.initialSize = initialSize;
        this.loadFactor = maxLoad;
        numberKeys = 0;
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

    private int hashCode(K key) {
        return -1;
    }

    private void resize(int initialSize) {

    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        //This will clear each entry from the linked list
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].clear();
        }

        numberKeys = 0;
    };

    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        if (key == null) {
            throw new IllegalArgumentException("Invalid key provided");
        }

        throw new UnsupportedOperationException();
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Invalid key provided");
        }
        return null;
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
        if (key == null) {
            throw new IllegalArgumentException("Invalid key provided");
        }
        throw new UnsupportedOperationException();
    }

    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    //This method does not need to be implemented
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
