package edu.sdccd.cisc191.template;

import java.util.ArrayList;

// Define some functions - implementing generics! - that every tree implementation must have
public interface Tree<E>
{
    boolean insert(E e);
    boolean contains(E e);
    int size();
    boolean remove(E e);
    E findMax();
    E findMin();
    void printPreOrder();
    void printPostOrder();
    void printInOrder();
    ArrayList<E> inOrderList();
    void empty();
    boolean isEmpty();
}