package com.github.algorithms.structure.array;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ListArraysTest {

    Logger logger = LoggerFactory.getLogger(ListArraysTest.class);

    @Test
    void quickSort() {
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(20);
        arrayList.add(30);
        logger.debug(arrayList.toString());
        ArrayList<Integer> arrayList1 = ListArrays.quickSort(arrayList);
        logger.debug("排序后");
        logger.debug(arrayList1.toString());
    }
}