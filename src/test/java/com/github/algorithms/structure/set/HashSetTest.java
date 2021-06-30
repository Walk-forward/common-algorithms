package com.github.algorithms.structure.set;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashSetTest {

    Logger logger = LoggerFactory.getLogger(HashSetTest.class);
    @Test
    public void tableSizeForTest() {
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = -1 >>> Integer.numberOfLeadingZeros(13);
        logger.debug("{}", (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);
    }
    @Test
    public void hashSetAddTest() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");
        hashSet.add("5");
        hashSet.add("6");
        hashSet.add("7");
        hashSet.add("8");
        hashSet.add("9");
        hashSet.add("10");
        hashSet.add("11");
        hashSet.add("12");
        hashSet.add("13");
        hashSet.add("14");
        hashSet.add("15");
        hashSet.add("16");
        hashSet.add("17");
        hashSet.add("18");
        hashSet.add("19");
        hashSet.add("20");
        hashSet.add("21");
        hashSet.add("22");
        hashSet.add("23");
        hashSet.add("24");
        hashSet.add("25");
        hashSet.add("26");
        hashSet.add("27");
        hashSet.add("28");
        hashSet.add("29");
        hashSet.add("30");
        hashSet.add("31");
        hashSet.add("32");
        hashSet.add("33");
        hashSet.add("34");
        printHashSet(hashSet);
    }

    private void printHashSet(HashSet<?> hashSet) {
        hashSet.forEach( e -> logger.debug("{}", e));
    }

}
