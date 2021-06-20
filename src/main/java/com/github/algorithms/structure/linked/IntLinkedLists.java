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

}
