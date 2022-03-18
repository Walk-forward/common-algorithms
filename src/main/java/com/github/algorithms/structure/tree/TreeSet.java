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
     * @return 队列
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
     * @return 队列
     */
    public Queue<E> inOrderTraversal() {
        Queue<E> queue = new Queue<>();
        Node node = this.root;
        Stack<Node> stack = new Stack<>();
        while (node != null || stack.getSize() != 0) {
            if (node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                Node pop = stack.pop();
                queue.push(pop.value);
                node = pop.rightNode;
            }
        }
        return queue;
    }

    /**
     * 后序遍历，左右根
     * 迭代
     * @return 队列
     */
    public Queue<E> postOrderTraversal() {
        Queue<E> queue = new Queue<>();
        Node node = this.root;
        Node node1 = this.root;
        Stack<Node> stack = new Stack<>();
        while (node != null || stack.getSize() != 0) {
            if (node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                Node pop = stack.pop();
                if (pop.rightNode == null || pop.rightNode == node1) {
                    node1 = pop;
                    queue.push(pop.value);
                } else {
                    node = pop.rightNode;
                    stack.push(pop);
                }
            }
        }
        return queue;
    }

    /**
     * 层次遍历（层次遍历广度优先遍历）
     * @return 队列
     */
    public Queue<E> breadthFirstTraversal() {
        Queue<E> queue = new Queue<>();
        if (this.root == null) {
            return queue;
        }
        Queue<Node> queue1 = new Queue<>();
        queue1.push(this.root);
        while (queue1.getSize() != 0) {
            Node node = queue1.pop();
            queue.push(node.value);
            if (node.leftNode != null) {
                queue1.push(node.leftNode);
            }
            if (node.rightNode != null) {
                queue1.push(node.rightNode);
            }
        }
        return queue;
    }

    private class Node {
        private E value;
        private Node leftNode;
        private Node rightNode;
    }
}
