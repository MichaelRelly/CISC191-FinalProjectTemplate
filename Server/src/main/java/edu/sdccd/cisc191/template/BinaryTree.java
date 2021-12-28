package edu.sdccd.cisc191.template;

import java.util.ArrayList;

public abstract class BinaryTree<E> implements Tree<E>
{
    // The topmost node of the BinaryTree
    protected Node<E> root;

    /** constructors */
    public BinaryTree()
    {
        // A new BinaryTree instantiated without arguments has no root yet.
        root = null;
    }
    public BinaryTree(E rootItem)
    {
        // If the constructor is provided an arg during instantiation, this generic arg will be the root
        root = new Node<E>(rootItem, null, null);
    }

    /** Return the size of the binary tree */
    public int size()
    {
        return root.size();
    }

    /** Print elements of the binary tree in pre Order */
    public void printPreOrder()
    {
        if (root!=null)
            root.printPreOrder();
    }

    /** Print elements of the binary tree in post Order */
    public void printPostOrder()
    {
        if (root!=null)
            root.printPostOrder();
    }

    /** Print elements of the binary tree in Order */
    public void printInOrder()
    {
        if (root!=null)
            root.printInOrder();
    }

    /** Return a list of elements in order */
    public ArrayList<E> inOrderList()
    {
        ArrayList<E> list = new ArrayList<E>();
        root.inOrderList(list);
        return list;
    }

    /** Make the binary tree empty */
    public void empty()
    {
        root = null;
    }

    /** Check whether the binary tree is empty or not */
    public boolean isEmpty()
    {
        return root == null;
    }
}