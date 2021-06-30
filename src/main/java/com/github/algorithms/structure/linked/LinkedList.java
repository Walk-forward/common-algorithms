package com.github.algorithms.structure.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 链表集合
 * @param <E> 集合类型
 */
public class LinkedList<E> implements Iterator<E>, Iterable<E> ,Cloneable {

    /**
     * 头节点
     */
    private Node headNode;

    /**
     * 下一个节点
     */
    private Node nextNode;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 迭代器当前节点
     */
    private Node iteratorNode;

    /**
     * 迭代器上一个节点
     */
    private Node iteratorFirstNode;

    public LinkedList() {
        this.headNode = new Node();
        this.nextNode = this.headNode;
    }

    /**
     * 插入元素
     * @param value 元素
     */
    public void insert(E value) {
        Node node = new Node();
        this.nextNode.value = value;
        this.nextNode.node = node;
        this.nextNode = node;
        this.size ++;
    }

    /**
     * 根据索引修改元素
     * @param index 索引
     * @param value 元素
     * @return 旧元素
     */
    public E set(int index, E value) {
        if (index >= this.size || index < 0) {
            throw new NoSuchElementException();
        }
        Node next = this.headNode;
        for (int i = 0; i < index; i++) {
            next = next.node;
        }
        E oldValue = next.value;
        next.value = value;
        return oldValue;
    }

    /**
     * 删除元素
     * @param value 元素
     */
    public void delete(E value) {
        Node next = this.headNode;
        Node front = this.headNode;
        while (next.node != null) {
            if (value == next.value) {
                if (this.headNode == next) {
                    this.headNode = next.node;
                }else {
                    front.node = next.node;
                }
                this.size --;
                break;
            }
            if (next != front) {
                front = front.node;
            }
            next = next.node;
        }
    }

    /**
     * 删除元素
     * @param node 元素
     */
    public void delete(Node node) {
        if (node == null) {
            throw new NoSuchElementException();
        }
        Node next = this.headNode;
        Node front = this.headNode;
        while (next.node != null) {
            if (node.equals(next)) {
                if (this.headNode == next) {
                    this.headNode = next.node;
                }else {
                    front.node = next.node;
                }
                this.size --;
                break;
            }
            if (next != front) {
                front = front.node;
            }
            next = next.node;
        }
    }

    /**
     * 返回集合元素个数
     * @return 元素个数
     */
    public int size() {
        return this.size;
    }

    @Override
    public boolean hasNext() {
        return this.iteratorNode.node != null;
    }

    @Override
    public E next() {
        this.iteratorFirstNode = this.iteratorNode;
        E value = this.iteratorNode.value;
        this.iteratorNode = this.iteratorNode.node;
        return value;
    }

    @Override
    public void remove() {
        delete(this.iteratorFirstNode);
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
        this.iteratorNode = this.headNode;
        Iterator.super.forEachRemaining(action);
    }

    @Override
    public Iterator<E> iterator() {
        this.iteratorNode = this.headNode;
        return this;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }

    @SuppressWarnings("unchecked")
    public LinkedList<E> clone() throws CloneNotSupportedException {
        LinkedList<E> clone = (LinkedList<E>) super.clone();
        clone.headNode = new Node();
        clone.nextNode = clone.headNode;
        clone.iteratorNode = null;
        clone.size = 0;
        this.forEachRemaining(clone::insert);
        return clone;
    }

    private class Node {
        private E value;
        private Node node;
    }
}
