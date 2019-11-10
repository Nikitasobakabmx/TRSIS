package com.javaClasses;
import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.Objects;
import java.lang.RuntimeException;

public class BTree<T extends Number & Comparable<? super T>, Y> {
    class Node<T  extends Number & Comparable<? super T>, Y>{
        class Pair<T  extends Number & Comparable<? super T>, Y>{
            public T _key;
            public Y _value;
            Pair(){

            }
            Pair(T key, Y val){
                _key = key;
                _value = val;
            }
        }
        private Pair<T, Y>[] pairs;
        private Node<T, Y>[] children;
        private int _K;
        private int _currentSize;
        Node(){
            //K = 2(default)
            this(2);
        }
        Node(int K){
            //every one node have K * 2 pair of key and value
            //it likes points on mathematical numerical axis
            pairs = (Pair<T, Y>[])new Pair[K * 2];// java is the piece of shit

            //every one node have K * 2 + 1 child nodes
            //it likes gaps on mathematical numerical axis
            children = (Node<T,Y>[]) new Node[K * 2 + 1];// java is the piece of shit
        }
        Node(T key, Y val){
            this(key, val, 2);
        }
        Node(T key, Y val, int K){
            this(K);
            pairs[0] = new Pair<T,Y>(key, val);
            _currentSize++;
        }
        StringBuilder toStringBuilder(){
            //symmetric tree walk // eng mast correct
            StringBuilder tmp = new StringBuilder();
            for(int i = 0; i < 4; i++){
                if(children[i] != null)
                    tmp.append(children[i].toStringBuilder());
                if(pairs[i] != null)
                    tmp.append(pairs[i]._value);
            }
            if(children[4] != null)
                tmp.append(children[4].toStringBuilder());
            return tmp;
        }
        public Pair<T, Y> get(T key)throws RuntimeException{
            for(int i = 0; i < _K*2; i++){
                if (pairs[i] != null){
                    Integer tmp = pairs[i]._key.compareTo(key);
                    if(tmp == 0)
                        return pairs[i];
                    if(tmp < 0 && children[i] != null)
                        return children[i].get(key);
                    if(tmp > 0 && i == _K * 2 && children[_K * 2 + 1] != null)
                        return children[i + 1].get(key);
                }
            }
            throw new RuntimeException("Not found ");
        }
    }

    private Node<T, Y> _begin;
    private int _size;
    BTree() {
        _begin = new Node<T, Y>();
    }
    BTree(int K) {
        _begin = new Node<T, Y>(K);
    }
    BTree(T key, Y val) {
        _begin = new Node<T, Y>(key, val);
        _size++;
    }
    BTree(T key, Y val, int K) {
        _begin = new Node<T, Y>(key, val, K);
        _size++;
    }
    public String toString(){
        return _begin.toStringBuilder().toString();
    }
    public void append(T key, Y value){
        Node<T,Y>.Pair<T, Y> tmp = _begin.get(key);
    }
    public boolean remove(T key){
        return false;
    }
    public Y get(T key){
        return _begin.get(key)._value;
    }
}
