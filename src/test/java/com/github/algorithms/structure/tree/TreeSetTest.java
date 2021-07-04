package com.github.algorithms.structure.tree;

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

}
