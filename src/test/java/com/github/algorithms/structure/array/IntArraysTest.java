package com.github.algorithms.structure.array;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntArraysTest {

    Logger logger = LoggerFactory.getLogger(IntArraysTest.class);

    /**
     * 测试查找最小值
     */
    @Test
    public void intArraysFindMinTest() {
        IntArray intArray = new IntArray(10);
        intArray.add(5);
        intArray.add(2);
        intArray.add(3);
        logger.debug("最小数组下标 {}", IntArrays.minIndex(intArray));
    }

    /**
     * 测试选择排序
     */
    @Test
    public void intArraysSelectSortTest() {
        IntArray intArray = new IntArray(10);
        intArray.add(5);
        intArray.add(2);
        intArray.add(3);
        printIntArray(intArray);
        intArray = IntArrays.selectSort(intArray);
        logger.debug("排序后");
        printIntArray(intArray);
    }

    /**
     * 测试二分查找
     */
    @Test
    public void intArraysBinarySearchTest() {
        IntArray intArray = new IntArray(10);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);
        int element = IntArrays.binarySearch(intArray, -6);
        logger.debug("找到的元素下标是 {}", element);
    }

    /**
     * 测试快速排序
     */
    @Test
    public void intArraysQuickSortTest() {
        IntArray intArray = new IntArray(10);
        intArray.add(5);
        intArray.add(2);
        intArray.add(3);
        intArray.add(5);
        intArray.add(2);
        intArray.add(3);
        intArray.add(20);
        intArray.add(30);
        printIntArray(intArray);
        intArray = IntArrays.quickSort(intArray);
        logger.debug("排序后");
        printIntArray(intArray);
    }

    private void printIntArray(IntArray intArray) {
        for (int i = 0; i < intArray.size(); i++) {
            logger.debug("数组 {}, {}", i, intArray.get(i));
        }
    }
}
