package com.github.algorithms.structure.array;

public class IntArrays {

    /**
     * 选择排序
     * @param intArray 需要排序的
     * @return 有序的数组
     */
    public static IntArray selectSort(IntArray intArray) {
        IntArray sort = new IntArray(intArray.size());
        int size = intArray.size();
        for (int i = 0; i < size; i++) {
            int index = minIndex(intArray);
            sort.add(intArray.get(index));
            intArray.remove(index);
        }
        return sort;
    }

    /**
     * 获取集合中的最小值下标
     * @param intArray 集合
     * @return 下标
     */
    public static int minIndex(IntArray intArray) {
        int minIndex = 0;
        for (int i = 1; i < intArray.size(); i++) {
            if (intArray.get(minIndex) > intArray.get(i)) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * 二分查找
     * 要查找的集合必须是有序的
     * @param intArray 集合
     * @param element 元素
     * @return 元素在集合中的下标
     */
    public static int binarySearch(IntArray intArray, int element) {
        int index = -1;
        int min = 0;
        int max = intArray.size() - 1;
        while (min <= max) {
            int guess = (min + max) / 2;
            if(intArray.get(guess) > element) {
                max = guess - 1;
            }else if(intArray.get(guess) < element) {
                min = guess + 1;
            }else {
                index =  guess;
                break;
            }
        }
        return index;
    }

}
