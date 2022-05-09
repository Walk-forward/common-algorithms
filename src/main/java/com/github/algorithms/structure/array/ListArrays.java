package com.github.algorithms.structure.array;

public class ListArrays {


    /**
     * 快速排序
     * @param arrayList 集合
     */
    public static <T extends Comparable<T>> ArrayList<T> quickSort(ArrayList<T> arrayList) {
        try {
            return quickSortA(arrayList.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 快速排序
     * @param arrayList 集合
     * @return 有序的集合
     */
    public static <T extends Comparable<T>> ArrayList<T> quickSortA(ArrayList<T> arrayList) {
        if (arrayList.size() < 2) {
            return arrayList;
        }
        int baseIndex = (int)Math.floor(arrayList.size() / 2f);
        T baseValue = arrayList.get(baseIndex);
        arrayList.remove(baseIndex);
        ArrayList<T> leftArrayList = new ArrayList<>(arrayList.size());
        ArrayList<T> rightArrayList = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            if (baseValue.compareTo(arrayList.get(i)) > 0) {
                leftArrayList.add(arrayList.get(i));
            }else {
                rightArrayList.add(arrayList.get(i));
            }
        }
        return merge(quickSortA(leftArrayList), baseValue, quickSortA(rightArrayList));
    }

    /**
     * 合并快速排序结果
     * @param leftArrayList 左边集合
     * @param baseValue 元素
     * @param rightArrayList 右边集合
     * @return 合并后的集合
     */
    private static <T> ArrayList<T> merge(ArrayList<T> leftArrayList, T baseValue, ArrayList<T> rightArrayList) {
        ArrayList<T> arrayList = new ArrayList<>(leftArrayList.size() + 1 + rightArrayList.size());
        for (int i = 0; i < leftArrayList.size(); i++) {
            arrayList.add(leftArrayList.get(i));
        }
        arrayList.add(baseValue);
        for (int i = 0; i < rightArrayList.size(); i++) {
            arrayList.add(rightArrayList.get(i));
        }
        return arrayList;
    }
}
