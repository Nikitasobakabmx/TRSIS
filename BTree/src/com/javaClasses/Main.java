package com.javaClasses;
import com.javaClasses.BTree;

public class Main extends Object {

    public static void main(String args[]){
        BTree<Integer, String> tree = new BTree<>(10, "Hello", 2);
        System.out.println(tree.toString());
    }

}
