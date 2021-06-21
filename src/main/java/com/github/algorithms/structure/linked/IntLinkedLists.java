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
        if (intLinkedList.size() < 2) {
            return intLinkedList;
        }
        intLinkedList.iterator();
        int baseValue = intLinkedList.next();
        IntLinkedList leftIntLinkedList = new IntLinkedList();
        IntLinkedList rightIntLinkedList = new IntLinkedList();
        while (intLinkedList.hasNext()) {
            int value = intLinkedList.next();
            if (baseValue > value) {
                leftIntLinkedList.insert(value);
            }else {
                rightIntLinkedList.insert(value);
            }
        }
        return merge(quickSort(leftIntLinkedList), baseValue, quickSort(rightIntLinkedList));
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
