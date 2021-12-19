package edu.sdccd.cisc191.template;

import java.util.ArrayList;

public class Node<E>{
    // Each Tree Node has the following characteristics
    protected E element;
    protected Node<E> left;
    protected Node<E> right;

    /** constructors */
    public Node(){
        this(null, null, null);
    }

    public Node(E theElement, Node<E> lt, Node<E> rt)
    {
        element = theElement;
        left = lt;
        right = rt;
    }

    /**  Return the size of the binary node */
    public int size(){
        return size(this);
    }

    /** Print elements of the binary node in pre Order */
    public void printPreOrder(){
        System.out.println(element);
        if ( left != null )
            left.printPreOrder();
        if ( right != null )
            right.printPreOrder();
    }

    /** Print elements of the binary node in post Order */
    public void printPostOrder(){
        if ( left != null )
            left.printPostOrder();
        if ( right != null )
            right.printPostOrder();
        System.out.println(element);
    }

    /** Print elements of the binary node in Order */
    public void printInOrder(){
        if ( left != null )
            left.printInOrder();
        System.out.println(element);
        if ( right != null )
            right.printInOrder();
    }

    /** Put elements of the binary node in order in a provided list */
    public void inOrderList(ArrayList<E> list) {
        if ( left != null )
            left.inOrderList(list);
        list.add(element);
        if ( right != null )
            right.inOrderList(list);
    }

    /** Return the size of a certain binary node */
    private int size(Node<E> t){
        if (t == null)
            return 0;
        else
            // add up the size of left node and right node and the element itself
            return 1+size(t.left)+size(t.right);
    }
}
