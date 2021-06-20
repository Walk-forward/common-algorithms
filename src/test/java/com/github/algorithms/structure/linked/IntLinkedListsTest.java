package com.github.algorithms.structure.linked;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntLinkedListsTest {

    Logger logger = LoggerFactory.getLogger(IntLinkedListsTest.class);

    /**
     * 测试链表选择排序
     */
    @Test
    public void intLinkedListsSelectSortTest() {
        IntLinkedList intLinkedList = new IntLinkedList();
        intLinkedList.insert(1);
        intLinkedList.insert(3);
        intLinkedList.insert(2);
        IntLinkedList sort = IntLinkedLists.selectSort(intLinkedList);
        printIntLinkedList(sort);
        logger.debug("----------排序前----------");
        printIntLinkedList(intLinkedList);
    }

    private void printIntLinkedList(IntLinkedList intLinkedList) {
        intLinkedList.forEach(v -> logger.debug("链表 {}", v));
    }
}
