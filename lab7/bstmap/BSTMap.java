package bstmap;

import edu.princeton.cs.algs4.SET;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    //Initialize root of tree
    private BSTNode root;
    private int size;

    //Private class BSTNode to complete the node
    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left, right;

        //Constructor for the node
        public BSTNode(K key, V value, int size){
            this.key = key;
            this.value = value;

        }
    }
    //Constructor for BSTmap
    public BSTMap() {
        size = 0;
    }

    public void clear(){
        throw new UnsupportedOperationException("Invalid Operation");
    }

    public boolean containsKey(K key){
        throw new UnsupportedOperationException("Invalid Operation");
    }

    public V get(K key){
        throw new UnsupportedOperationException("Invalid Operation");
    }

    public int size() {
        return size;
    }

    public void put(K key, V value){
        throw new UnsupportedOperationException("Invalid Operation");
    }

    public Set<K> keySet(){
        throw new UnsupportedOperationException("Invalid Operation");
    }

    public V remove(K key){
        throw new UnsupportedOperationException("Invalid Operation");
    }

    public V remove(K key, V value){
        throw new UnsupportedOperationException("Invalid Operation");
    }

}
