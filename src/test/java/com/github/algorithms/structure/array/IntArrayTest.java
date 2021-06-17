package com.github.algorithms.structure.array;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntArrayTest {

    Logger logger = LoggerFactory.getLogger(IntArrayTest.class);

    /**
     * 测试数组集合添加
     */
    @Test
    public void intArrayAddTest() {
        IntArray intArray = new IntArray(3);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        printIntArray(intArray);
    }

    /**
     * 测试数组集合删除
     */
    @Test
    public void intArrayRemoveTest() {
        IntArray intArray = new IntArray(10);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        printIntArray(intArray);

        intArray.remove(1);
        printIntArray(intArray);
    }

    /**
     * 测试数组集合获取元素
     */
    @Test
    public void intArrayGetTest() {
        IntArray intArray = new IntArray(10);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        printIntArray(intArray);

        logger.debug("get方法返回值为： {}", intArray.get(0));
    }

    /**
     * 测试数组集合设置元素
     */
    @Test
    public void intArraySetTest() {
        IntArray intArray = new IntArray(10);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        printIntArray(intArray);

        logger.debug("set方法返回值为：{}", intArray.set(2, 20));
        printIntArray(intArray);
    }

    private void printIntArray(IntArray intArray) {
        for (int i = 0; i < intArray.size(); i++) {
            logger.debug("数组 {}, {}", i, intArray.get(i));
        }
    }
}
