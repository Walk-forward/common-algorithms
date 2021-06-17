package com.github.algorithms.structure.linked;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 整数类型
 * 链表集合
 */
public class IntLinkedList implements Iterator<Integer>, Iterable<Integer> {

    /**
     * 头节点
     */
    private Link headLink;

    /**
     * 下一个节点
     */
    private Link nextLink;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 下一个节点
     */
    private Link iterator;

    public IntLinkedList() {
        this.headLink = new Link();
        this.nextLink = this.headLink;
    }

    /**
     * 插入元素
     * @param data 元素
     */
    public void insert(int data) {
        Link link = new Link();
        this.nextLink.data = data;
        this.nextLink.next = link;
        this.nextLink = link;
        this.size ++;
    }

    /**
     * 删除元素
     * @param data 元素
     */
    public void delete(int data) {
        Link next = this.headLink;
        Link front = this.headLink;
        while (next.next != null) {
            if (data == next.data) {
                front.next = next.next;
                this.size --;
                break;
            }
            if (next != front) {
                front = front.next;
            }
            next = next.next;
        }
    }

    /**
     * 删除元素
     * @param link 元素
     */
    public void delete(Link link) {
        Link next = this.headLink;
        Link front = this.headLink;
        while (next.next != null) {
            if (link.equals(next)) {
                front.next = next.next;
                this.size --;
                break;
            }
            if (next != front) {
                front = front.next;
            }
            next = next.next;
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
        return this.iterator.next != null;
    }

    @Override
    public Integer next() {
        int data = this.iterator.data;
        this.iterator = this.iterator.next;
        return data;
    }

    @Override
    public void remove() {
        delete(iterator);
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        iterator = headLink;
        Iterator.super.forEachRemaining(action);
    }

    @Override
    public Iterator<Integer> iterator() {
        iterator = headLink;
        return this;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }

    private class Link {
        private int data;
        private Link next;
    }
}
