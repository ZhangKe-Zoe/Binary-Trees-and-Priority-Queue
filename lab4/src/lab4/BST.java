package lab4;

import java.util.Iterator;
import java.util.Stack;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apple
 */
public class BST< Key extends Comparable<Key>, Value>implements Iterable<Key>{

    private class Node {

        Key key;
        Value value;
        Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node root;

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo((x.key));
            if (cmp == 0) {
                return x.value;
            } else if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            }

        }
        return null;
    }

    public void put(Key key, Value value) {

        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.value = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
        return x;
    }
@Override
    public Iterator<Key> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<Key> {

        private Stack<Node> stack = new Stack<Node>();

        public BSTIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node x) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Key next() {
            Node x = stack.pop();
            pushLeft(x.right);
            return x.key;
        }

    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node x) {
        if (x == null) {
            return 0;
        }
        int leftDepth = depth(x.left);
        int rightDepth = depth(x.right);
        int level = (leftDepth > rightDepth) ? leftDepth : rightDepth;
        return level + 1;

    }
}
