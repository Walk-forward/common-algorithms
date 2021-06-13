package com.github.algorithms.structure.array;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntArraysTest {

    Logger logger = LoggerFactory.getLogger(IntArraysTest.class);

    @Test
    public void intArraysFindMinTest() {
        IntArray intArray = new IntArray(10);
        intArray.add(5);
        intArray.add(2);
        intArray.add(3);
        logger.debug("最小数组下标 {}", IntArrays.minIndex(intArray));
    }

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

    private void printIntArray(IntArray intArray) {
        for (int i = 0; i < intArray.size(); i++) {
            logger.debug("数组 {}, {}", i, intArray.get(i));
        }
    }
}
