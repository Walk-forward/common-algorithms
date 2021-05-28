package com.github.algorithms.structure.array;

public class IntArray {

    /* 元素 */
    private int[] elementData;

    private int size;

    private IntArray() {
    }

    public IntArray(int length) {
        this.elementData = new int[length];
        this.size = 0;
    }

    public int get(int index) {
        return this.elementData[index];
    }

    public int set(int index, int element) {
        return this.elementData[index] = element;
    }

    public void add(int element) {
        this.elementData[size] = element;
        this.size ++;
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
        this.size --;
    }

    public int size() {
        return this.size;
    }

}
