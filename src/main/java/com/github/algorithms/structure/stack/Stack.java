package com.github.algorithms.structure.stack;

/**
 * 栈
 */
public class Stack<E> {

    /**
     * 头节点
     */
    private Node topNode;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 入栈
     * @param element 元素
     */
    public void push(E element) {
        Node node = new Node();
        node.value = element;
        if (topNode != null) {
            node.node = this.topNode;
        }
        this.topNode = node;
        this.size ++;
    }

    /**
     * 出栈
     * @return 栈顶元素
     * @throws RuntimeException 栈空异常
     */
    public E pop() throws RuntimeException {
        if (topNode == null) {
            throw new RuntimeException("栈空");
        }
        E old = this.topNode.value;
        this.topNode = this.topNode.node;
        this.size --;
        return old;
    }

    /**
     * 返回栈顶元素，但不删除
     * @return 栈顶元素
     */
    public E peek() {
        return this.topNode.value;
    }

    /**
     * 测试栈是否为空
     * @return 栈为空返回 true, 否则返回 false
     */
    public boolean empty() {
        return this.topNode == null;
    }

    /**
     * 获取栈中元素数量
     * @return 栈中元素数量
     */
    public int getSize() {
        return size;
    }

    private class Node {
        private E value;
        private Node node;
    }
}
