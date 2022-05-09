package com.github.algorithms.structure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * 数组集合
 */
public class ArrayList<E> implements Iterator<E>, Iterable<E>, Cloneable {

    /**
     * 元素
     */
    private E[] elementData;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 迭代器下标
     */
    private int index;

    /**
     * 创建集合
     */
    public ArrayList() {
        this(16);
    }

    /**
     * 指定集合容量
     * @param length 集合容量
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int length) {
        this.elementData = (E[]) new Object[length];
        this.size = 0;
    }

    /**
     * 返回集合元素个数
     * @return 元素个数
     */
    public int size() {
        return this.size;
    }

    /**
     * 添加一个元素
     * @param element 元素
     */
    @SuppressWarnings("unchecked")
    public void add(E element) {
        if (size == elementData.length) {
            E[] elementNew = (E[]) new Object[size * 2];
            for (int i = 0; i < this.size; i++) {
                elementNew[i] = this.elementData[i];
            }
            this.elementData = elementNew;
        }
        this.elementData[size] = element;
        this.size ++;
    }

    /**
     * 删除指定下标元素
     * @param index 下标索引
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("下标索引元素不存在");
        }
        E oldElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
        this.size --;
        return oldElement;
    }

    /**
     * 获取集合元素
     * @param index 下标索引
     * @return 返回指定下标的集合元素
     */
    public E get(int index) {
        if (index >= elementData.length) {
            throw new RuntimeException("集合下标索引越界");
        }
        return this.elementData[index];
    }

    /**
     * 设置集合元素
     * @param index 下标索引
     * @param element 元素
     * @return 返回该下标原有元素
     */
    public E set(int index, E element) {
        if (index >= elementData.length) {
            throw new RuntimeException("集合下标索引越界");
        }
        E oldElement = this.elementData[index];
        this.elementData[index] = element;
        if (oldElement == null) {
            this.size ++;
        }
        return oldElement;
    }

    @Override
    public Iterator<E> iterator() {
        this.index = 0;
        return this;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public boolean hasNext() {
        return this.index < this.elementData.length;
    }

    @Override
    public E next() {
        return elementData[index ++];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return size == arrayList.size && Arrays.equals(elementData, arrayList.elementData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elementData);
        return result;
    }

    @Override
    public ArrayList<E> clone() throws CloneNotSupportedException {
        ArrayList<E> arrayList = (ArrayList) super.clone();
        arrayList.elementData = this.elementData.clone();
        return arrayList;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == null) {
                break;
            }else if (i == 0) {
                stringBuffer.append(elementData[i].toString());
                continue;
            }
            stringBuffer.append(", ").append(elementData[i].toString());
        }
        return "ArrayList{" +
                "elementData=[" + stringBuffer + "]" +
                '}';
    }
}
