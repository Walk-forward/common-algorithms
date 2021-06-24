package com.github.algorithms.structure.array;

/**
 * 数组集合
 */
public class ArrayList<E> {

    /**
     * 元素
     */
    private E[] elementData;

    /**
     * 元素个数
     */
    private int size;

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
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("下标索引元素不存在");
        }
        for (int i = index; i < size - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
        this.size --;
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
        return oldElement;
    }

}
