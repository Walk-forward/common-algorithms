package com.github.algorithms.structure.tree;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 数集
 * @param <E>
 */
public class TreeSet<E extends Comparable<E>> implements Iterator<E>, Iterable<E> {

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

    @Override
    public Iterator<E> iterator() {
        iteratorNode = root;
        return this;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
    private class Node {
        private E value;
        private Node leftNode;
        private Node rightNode;
    }
}
