package com.github.algorithms.structure.tree;

import com.github.algorithms.structure.queue.Queue;
import com.github.algorithms.structure.stack.Stack;

/**
 * 数集
 * @param <E>
 */
public class TreeSet<E extends Comparable<E>> {

    private Node root;

    /**
     * 迭代器当前节点
     */
    private Node iteratorNode;

    /**
     * 添加元素
     * @param value 元素
     * @throws NullPointerException 元素不能为null
     */
    public void add(E value) throws NullPointerException{
        if (value == null) {
            throw new NullPointerException("不能将null添加到集合中");
        }
        Node newNode = new Node();
        newNode.value = value;
        if (root == null) {
            this.root = newNode;
        }else {
            addNode(this.root, newNode);
        }
    }

    private boolean addNode(Node node, Node newNode) {
        boolean b = true;
        if (newNode.value.compareTo(node.value) < 0) {
            if (node.leftNode == null) {
                node.leftNode = newNode;
            }else {
                b = addNode(node.leftNode, newNode);
            }
        }else if (newNode.value.compareTo(node.value) > 0) {
            if (node.rightNode == null) {
                node.rightNode = newNode;
            }else {
                b = addNode(node.rightNode, newNode);
            }
        }else {
            b = false;
        }
        return b;
    }

//    public E delete() {
//
//    }

    /**
     * 先序遍历（深度优先遍历）,根左右
     * 迭代
     * @return
     */
    public Queue<E> preorderTraversal() {
        Queue<E> queue = new Queue<>();
        if (this.root == null) {
            return queue;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);
        while (stack.getSize() != 0) {
            Node node = stack.pop();
            queue.push(node.value);
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
        return queue;
    }

    /**
     * 中序遍历，左中右
     * 迭代
     * @return
     */
    private Queue<E> inOrderTraversal() {
        Queue<E> queue = new Queue<>();
        if (this.root == null) {
            return queue;
        }
        Node nodep = this.root;
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);
        while (stack.getSize() != 0) {
            if (stack.peek().leftNode == nodep) {
                nodep = stack.pop();
                queue.push(nodep.value);
            }else if(stack.peek().leftNode != null) {
                stack.push(stack.peek().leftNode);
            }else if(stack.peek().rightNode != null) {

            }else {
                nodep = stack.pop();
                queue.push(nodep.value);
            }
            Node node = stack.pop();
            queue.push(node.value);
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
        return queue;
    }

    /**
     * 后序遍历
     * @return
     */
    private Queue<E> postOrderTraversal() {
        Queue<E> queue = new Queue<>();

        return queue;
    }

    /**
     * 层次遍历（层次遍历广度优先遍历）
     * @return
     */
    private Queue<E> breadthFirstTraversal() {
        Queue<E> queue = new Queue<>();

        return queue;
    }

    private class Node {
        private E value;
        private Node leftNode;
        private Node rightNode;
    }
}
