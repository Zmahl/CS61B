package bstmap;

import edu.princeton.cs.algs4.SET;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Iterator;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    //Initialize root of tree
    private BSTNode root;

    //Private class BSTNode to complete the node
    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left, right;
        private int size;

        //Constructor for the node
        public BSTNode(K key, V value, int size){
            this.key = key;
            this.value = value;
            this.size = size;

        }

    }

    //Constructor for BSTmap
    public BSTMap() {
    }

    private int size(BSTNode x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }
    private V get(BSTNode x, K key){
        if (key == null){
            throw new IllegalArgumentException("Calls get() with a null key");
        }
        if (x == null){
            return null;
        }
        //Use the compare method here to compare keys to each other
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    private boolean contains(BSTNode x, K key){
        if (key == null) throw new IllegalArgumentException("Key is null");
        if (x == null) return false;
        int cmp = key.compareTo(x.key);

        if (cmp == 0){
            return true;
        }

        else if (cmp < 0){
            return contains(x.left, key);
        }

        else if (cmp > 0) {
            return contains(x.right, key);
        }

        return false;
    }

    private BSTNode put (BSTNode x, K key, V value) {
        if (x == null) return new BSTNode(key, value, 1);
        int cmp = key.compareTo(x.key);

        if (cmp == 0){
            x.value = value;
        }
        //Always set these equal, trust the recursion
        else if (cmp < 0){
            x.left = put(x.left, key, value);
        }
        else if (cmp > 0){
            x.right = put(x.right, key, value);
        }

        x.size = 1 + size(x.left) + size(x.right);

        return x;
    }

    private BSTNode removeNode(BSTNode x, K key){
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = removeNode(x.left, key);
        else if (cmp > 0) x.right = removeNode(x.right, key);
        else{
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            BSTNode t = x;
            //Sets x equal to the lowest node in the tree so it can be swapped out
            x = min(t.right);
            x.right = removeMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * will return the smallest value within the tree
     * @param x
     * @return
     */
    private BSTNode min(BSTNode x){
        if (x.left == null) return x;
        else return min(x.left);
    }

    private BSTNode removeMin(BSTNode x){
        if (x.left == null) return x.right;
        x.left = removeMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void clear(){
        //Sets the root equal to null, making everything else get picked up by the garbage collector
        this.root = null;
    }
    @Override
    public boolean containsKey(K key){
        if (key == null){
            throw new IllegalArgumentException("argument is null key");
        }
        //Uses the public key function to see if the tree contains the available results
        return contains(root, key);
    }
    @Override
    public V get(K key){
        return get(root, key);
    }
    @Override
    public int size() {
        return size(this.root);
    }

    @Override
    public void put(K key, V value){
        if (key == null) throw new IllegalArgumentException();

        root = put(root, key, value);
    }
    @Override
    public Set<K> keySet(){
        throw new UnsupportedOperationException("Invalid Operation");
    }
    @Override
    public V remove(K key){
        if (key == null) throw new IllegalArgumentException();
        V removed = get(key);
        root = removeNode(root, key);
        return removed;
    }
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("Invalid Operation");
    }

    public void printInOrder(){

    }

    @Override
    public Iterator<K> iterator(){
        return new BSTMapIterator();
    }

    private class BSTMapIterator implements Iterator<K>{
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public K next() {
            return null;
        }
    }

}
