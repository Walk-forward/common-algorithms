package com.github.algorithms.structure.hash;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashMapTest {

    Logger logger = LoggerFactory.getLogger(HashMapTest.class);

    /**
     * 测试散列表放入、取出节点
     */
    @Test
    public void hashMapPutGetTest() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "苹果");
        hashMap.put(2, "橘子");
        hashMap.put(3, "菠萝");
        hashMap.put(2, "水果");
        logger.debug("key = {}, value = {}", 1, hashMap.get(1));
        logger.debug("key = {}, value = {}", 2, hashMap.get(2));
        logger.debug("key = {}, value = {}", 3, hashMap.get(3));
        logger.debug("key = {}, value = {}", 311, hashMap.get(311));
    }
}
