package com.github.algorithms.structure.linked;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntLinkedListTest {

    Logger logger = LoggerFactory.getLogger(IntLinkedListTest.class);

    /**
     * 测试链表插入
     */
    @Test
    public void intLinkedListInsertTest() {
        IntLinkedList intLinkedList = new IntLinkedList();
        intLinkedList.insert(1);
        intLinkedList.insert(2);
        intLinkedList.insert(3);
        printIntLinkedList(intLinkedList);
    }

    /**
     * 测试链表删除
     */
    @Test
    public void intLinkedListDeleteTest() {
        IntLinkedList intLinkedList = new IntLinkedList();
        intLinkedList.insert(1);
        intLinkedList.insert(2);
        intLinkedList.insert(3);
        intLinkedList.insert(1);
        intLinkedList.insert(2);
        intLinkedList.insert(3);
        printIntLinkedList(intLinkedList);
        logger.debug("删除--- 1");
        intLinkedList.delete(1);
        logger.debug("链表长度 {}", intLinkedList.size());
        printIntLinkedList(intLinkedList);
    }

    /**
     * 测试链表删除
     */
    @Test
    public void intLinkedListRemoveTest() {
        IntLinkedList intLinkedList = new IntLinkedList();
        intLinkedList.insert(1);
        intLinkedList.insert(2);
        intLinkedList.insert(3);
        intLinkedList.insert(21);
        intLinkedList.insert(22);
        intLinkedList.insert(23);
        intLinkedList.iterator();
        while (intLinkedList.hasNext()) {
            Integer next = intLinkedList.next();
            logger.debug("{}", next);
            intLinkedList.remove();
        }
        printIntLinkedList(intLinkedList);
    }

    private void printIntLinkedList(IntLinkedList intLinkedList) {
        intLinkedList.forEach(v -> logger.debug("链表 {}", v));
    }
}
