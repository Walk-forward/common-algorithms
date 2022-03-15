package com.github.algorithms.structure.tree;

import com.github.algorithms.structure.queue.Queue;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeSetTest {

    Logger logger = LoggerFactory.getLogger(TreeSetTest.class);

    @Test
    public void treeSetAddTest() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        treeSet.add("4");

    }

    @Test
    public void preorderTraversalTest() {
        Queue<String> queueTest = new Queue<>();
        queueTest.push("5");
        queueTest.push("3");
        queueTest.push("2");
        queueTest.push("4");
        queueTest.push("6");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("5");
        treeSet.add("3");
        treeSet.add("6");
        treeSet.add("2");
        treeSet.add("4");
        Queue<String> queue = treeSet.preorderTraversal();
        queue.forEach(v -> logger.debug(v));
        assert queueTest.equals(queue);
    }

    @Test
    public void inOrderTraversalTest() {
        Queue<String> queueTest = new Queue<>();
        queueTest.push("2");
        queueTest.push("3");
        queueTest.push("4");
        queueTest.push("5");
        queueTest.push("6");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("5");
        treeSet.add("3");
        treeSet.add("6");
        treeSet.add("2");
        treeSet.add("4");
        Queue<String> queue = treeSet.inOrderTraversal();
        queue.forEach(v -> logger.debug(v));
        assert queueTest.equals(queue);
    }
}
