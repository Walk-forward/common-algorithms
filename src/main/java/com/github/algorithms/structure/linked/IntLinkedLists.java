package com.github.algorithms.structure.linked;

public class IntLinkedLists {

    /**
     * 选择排序
     * @param intLinkedList 集合
     * @return 有序的集合
     */
    public static IntLinkedList selectSort(IntLinkedList intLinkedList) {
        try {
            intLinkedList = intLinkedList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        IntLinkedList sort = new IntLinkedList();
        intLinkedList.iterator();
        while (intLinkedList.hasNext()) {
            int min = 0;
            boolean f = true;
            while (intLinkedList.hasNext()) {
                int data = intLinkedList.next();
                if (f) {
                    min = data;
                    f = false;
                } else if (min > data) {
                    min = data;
                }
            }
            intLinkedList.delete(min);
            intLinkedList.iterator();
            sort.insert(min);
        }
        return sort;
    }

    /**
     * 快速排序
     * @param intLinkedList 集合
     * @return 有序的集合
     */
    public static IntLinkedList quickSort(IntLinkedList intLinkedList) {
        try {
            IntLinkedList clone = intLinkedList.clone();
            return internalQuickSort(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        throw new NullPointerException();
    }
    /**
     * 快速排序
     * @param intLinkedList 集合
     * @return 有序的集合
     */
    private static IntLinkedList internalQuickSort(IntLinkedList intLinkedList) {
        if (intLinkedList.size() < 2) {
            return intLinkedList;
        }
        int baseNum = (int)Math.floor(Math.random() * intLinkedList.size()) + 1;
        intLinkedList.iterator();
        int baseValue = intLinkedList.next();
        for (int i = 1; i < baseNum; i++) {
            baseValue = intLinkedList.next();
        }
        intLinkedList.remove();
        IntLinkedList leftIntLinkedList = new IntLinkedList();
        IntLinkedList rightIntLinkedList = new IntLinkedList();
        intLinkedList.iterator();
        while (intLinkedList.hasNext()) {
            int value = intLinkedList.next();
            if (baseValue > value) {
                leftIntLinkedList.insert(value);
            }else {
                rightIntLinkedList.insert(value);
            }
        }
        return merge(internalQuickSort(leftIntLinkedList), baseValue, internalQuickSort(rightIntLinkedList));
    }

    /**
     * 合并快速排序结果
     * @param leftIntLinkedList 左边集合
     * @param baseValue 元素
     * @param rightIntLinkedList 右边集合
     * @return 合并后的集合
     */
    private static IntLinkedList merge(IntLinkedList leftIntLinkedList, int baseValue, IntLinkedList rightIntLinkedList) {
        leftIntLinkedList.insert(baseValue);
        rightIntLinkedList.forEach(leftIntLinkedList::insert);
        return leftIntLinkedList;
    }
}
