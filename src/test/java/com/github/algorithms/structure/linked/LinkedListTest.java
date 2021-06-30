package com.github.algorithms.structure.linked;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListTest {

    Logger logger = LoggerFactory.getLogger(LinkedListTest.class);

    /**
     * 测试链表插入
     */
    @Test
    public void linkedListInsertTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        printLinkedList(linkedList);
    }

    /**
     * 测试链表删除
     */
    @Test
    public void linkedListDeleteTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        printLinkedList(linkedList);
        logger.debug("删除--- 1");
        linkedList.delete(1);
        logger.debug("链表长度 {}", linkedList.size());
        printLinkedList(linkedList);
    }

    /**
     * 测试链表删除
     */
    @Test
    public void linkedListRemoveTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(21);
        linkedList.insert(22);
        linkedList.insert(23);
        linkedList.iterator();
        while (linkedList.hasNext()) {
            Integer next = linkedList.next();
            logger.debug("{}", next);
            linkedList.remove();
        }
        printLinkedList(linkedList);
    }

    /**
     * 测试链表删除
     */
    @Test
    public void linkedListSetTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.set(-1, 20);
        logger.debug("链表长度 {}", linkedList.size());
        printLinkedList(linkedList);
    }

    private void printLinkedList(LinkedList<?> linkedList) {
        linkedList.forEach(v -> logger.debug("链表 {}", v));
    }
}
