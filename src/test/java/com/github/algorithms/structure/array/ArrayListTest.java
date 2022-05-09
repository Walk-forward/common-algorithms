package com.github.algorithms.structure.array;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayListTest {

    Logger logger = LoggerFactory.getLogger(ArrayListTest.class);

    /**
     * 测试集合添加元素
     */
    @Test
    public void arrayListAddTest() {
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("a1");
        arrayList.add("a2");
        arrayList.add("a3");
        printArrayList(arrayList);
    }

    /**
     * 测试集合删除元素
     */
    @Test
    public void arrayListRemoveTest() {
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        printArrayList(arrayList);

        arrayList.remove(1);
        printArrayList(arrayList);
    }

    /**
     * 测试集合获取元素
     */
    @Test
    public void arrayListGetTest() {
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        printArrayList(arrayList);

        logger.debug("get方法返回值为： {}", arrayList.get(0));
    }

    /**
     * 测试集合设置元素
     */
    @Test
    public void arrayListSetTest() {
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        printArrayList(arrayList);

        logger.debug("set方法返回值为：{}", arrayList.set(2, "20"));
        printArrayList(arrayList);
    }

    /**
     * 测试集合自动扩容
     */
    @Test
    public void AutomaticExpansionTest() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        printArrayList(arrayList);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("3");
        printArrayList(arrayList);
    }

    private <E> void printArrayList(ArrayList<E> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            logger.debug("数组 {}, {}", i, arrayList.get(i));
        }
    }

    @Test
    public void cloneTest() throws CloneNotSupportedException {
        ArrayList<String> arrayList = new ArrayList<>(3);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        ArrayList<String> arrayList1 = arrayList.clone();
        arrayList1.set(1, "a");

        logger.debug("原集合 {}", arrayList);
        logger.debug("克隆集合 {}", arrayList1);
    }
}
