package edu.sdccd.cisc191.template;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E>
{
    // constructor
    public BinarySearchTree(){
        super();
    }

    // constructor
    public BinarySearchTree(E rootItem){
        super(rootItem);
    }

    /**
     * Insert a node, return success indicator
     *
     * @param E node
     * @return boolean
     */
    public boolean insert(E e){
        if (contains(e))
            return false;
        root = insert(e, root);
        return true;
    }

    /**
     * Return whether node is found
     *
     * @param e
     * @return boolean
     */
    public boolean contains(E e){
        return contains(e, root);
    }

    /**
     * Remove a node, return success indicator
     *
     * @param e
     * @return boolean
     */
    public boolean remove(E e){
        if (!contains(e))
            return false;
        root = remove(e, root);
        return true;
    }

    /**
     * Return the node value that is the max value
     *
     * @return E
     */
    public E findMax(){
        return findMax(root).element;
    }

    /**
     * Return the node value that is the min value
     *
     * @return E
     */
    public E findMin(){
        return findMin(root).element;
    }

    /**
     * Insert a value at a node
     * @param e
     * @param t
     * @return Node<E>
     */
    private Node<E> insert(E e, Node<E> t){
        if (t == null)
            t = new Node<E>(e, null, null);
        else if (e.compareTo(t.element)<0)
            t.left = insert(e, t.left);
        else if (e.compareTo(t.element)>0)
            t.right = insert(e, t.right);
        return t;
    }

    /**
     * Return boolean according to whether a node contains a value
     * @param e
     * @param t
     * @return boolean
     */
    private boolean contains(E e, Node<E> t){
        if (t == null)
            return false;

        int compareResult = e.compareTo(t.element);
        if (compareResult<0)
            // recursively search the left node
            return contains(e, t.left);
        else if (compareResult>0)
            // recrusively search the right node
            return contains(e, t.right);
        else
            return true;
    }

    /**
     * Remove the minimum of a node
     * @param t
     * @return Node<E>
     */
    private Node<E> removeMin(Node<E> t){
        // empty node has no min to remove
        if (t == null)
            return t;
        else if (t.left != null){
            t.left = removeMin(t.left);
            return t;
        } else
            // the element is the min if the node has no left node
            return t.right;
    }

    /**
     * Remove e an
     * @param e
     * @param t
     * @return Node<E>
     */
    private Node<E> remove(E e, Node<E> t){
        if (t == null)
            return t;

        int compareResult = e.compareTo(t.element);
        if (compareResult<0){
            // recursively call remove method for the left node
            t.left = remove(e, t.left);
        } else if (compareResult>0){
            // call for the right node
            t.right = remove(e, t.right);
        }else{ // when we finally find the element...
            if (t.left != null && t.right != null){ // ... check if the node has two leaves...
                t.element = findMin(t.right).element;
                t.right = removeMin(t.right);
            } else  // if the node has only one leaf
                t = ( t.left != null ) ? t.left : t.right;
        }
        return t;
    }

    /**
     * Retrieve the maximum valued node under node t
     * @param t
     * @return Node<E>
     */
    private Node<E> findMax(Node<E> t){
        // empty node has no max
        if (t == null)
            return null;

        if (t.right == null)
            // return the element if it is the right most one
            return t;
        else
            // otherwise return that which is to its right
            return findMax(t.right);
    }

    /**
     * Retrieve the minimum node under node t
     * @param t
     * @return Node<E>
     */
    private Node<E> findMin(Node<E> t){
        if (t == null)
            return null;

        if (t.left == null)
            // return the element if it is the left most one
            return t;
        else
            return findMin(t.left);
    }
}