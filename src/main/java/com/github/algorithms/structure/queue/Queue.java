package com.github.algorithms.structure.queue;

import com.github.algorithms.structure.array.ArrayList;

import java.util.Iterator;
import java.util.StringJoiner;
import java.util.function.Consumer;

/**
 * 队列
 */
public class Queue<E> implements Iterator<E>, Iterable<E> {

    /**
     * 队头节点
     */
    private Node headNode;

    /**
     * 队尾节点
     */
    private Node endNode;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 迭代器当前节点
     */
    private Node iteratorNode;
    /**
     * 入队
     * @param element 元素
     */
    public void push(E element) {
        Node node = new Node();
        node.value = element;
        if (this.headNode == null) {
            this.headNode = node;
        }else {
            this.endNode.nextNode = node;
        }
        this.endNode = node;
        this.size ++;
    }

    /**
     * 出队
     * @return 队尾元素
     * @throws RuntimeException 队空异常
     */
    public E pop() throws RuntimeException {
        if (headNode == null) {
            throw new RuntimeException("队空");
        }
        E old = this.headNode.value;
        this.headNode = this.headNode.nextNode;
        this.size --;
        return old;
    }

    /**
     * 获取栈中元素数量
     * @return 栈中元素数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     * @return 为空返回 true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        iteratorNode = this.headNode;
        return this;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public boolean hasNext() {
        return iteratorNode != null;
    }

    @Override
    public E next() {
        E value = iteratorNode.value;
        iteratorNode = iteratorNode.nextNode;
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue<?> queue = (Queue<?>) o;
        if (size != queue.size) return false;
        Iterator<E> thisIterator = this.iterator();
        Iterator<?> iterator = queue.iterator();
        while (thisIterator.hasNext() && iterator.hasNext()) {
            if (!thisIterator.next().equals(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        ArrayList<E> arrayList = new ArrayList<>(size);
        for (E e : this) {
            arrayList.add(e);
        }
        return arrayList.hashCode();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            stringJoiner.add(iterator.next().toString());
        }

        return "Queue{" +
                "headNode=" + stringJoiner +
                '}';
    }

    private class Node {
        private E value;
        private Node nextNode;
    }
}
