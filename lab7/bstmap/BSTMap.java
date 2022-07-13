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
    @Override
    public void clear(){
        throw new UnsupportedOperationException("Invalid Operation");
    }
    @Override
    public boolean containsKey(K key){
        throw new UnsupportedOperationException("Invalid Operation");
    }
    @Override
    public V get(K key){
        BSTNode T = root;
        if (T == null){
            return null;
        }
        if (T.key == key){
            return T.value;
        }
        else if (T.key < key) {

        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void put(K key, V value){
        throw new UnsupportedOperationException("Invalid Operation");
    }
    @Override
    public Set<K> keySet(){
        throw new UnsupportedOperationException("Invalid Operation");
    }
    @Override
    public V remove(K key){
        throw new UnsupportedOperationException("Invalid Operation");
    }
    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException("Invalid Operation");
    }

    public void printInOrder(){

    }

}
