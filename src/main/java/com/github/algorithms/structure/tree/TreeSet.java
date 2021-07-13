package com.github.algorithms.structure.tree;

import com.github.algorithms.structure.queue.Queue;

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
     * 先序遍历（深度优先遍历）
     * 迭代、递归
     * @return
     */
    private Queue<E> preorderTraversal() {
        Queue<E> queue = new Queue<>();

        return queue;
    }

    /**
     * 中序遍历
     * @return
     */
    private Queue<E> inOrderTraversal() {
        Queue<E> queue = new Queue<>();

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
