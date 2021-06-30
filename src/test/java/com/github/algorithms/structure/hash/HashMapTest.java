package com.github.algorithms.structure.hash;

import com.github.algorithms.structure.set.HashSet;
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
        HashMap<Integer, String> hashMap = new HashMap<>(2);
        hashMap.put(1, "苹果");
        hashMap.put(2, "橘子");
        hashMap.put(3, "菠萝");
//        hashMap.put(4, "水果");
//        hashMap.put(11, "苹果");
//        hashMap.put(12, "橘子");
//        hashMap.put(13, "菠萝");
//        hashMap.put(14, "水果");
//        hashMap.put(21, "苹果");
//        hashMap.put(22, "橘子");
//        hashMap.put(23, "菠萝");
//        hashMap.put(24, "水果");
//        hashMap.put(31, "苹果");
//        hashMap.put(32, "橘子");
//        hashMap.put(33, "菠萝");
//        hashMap.put(34, "水果");
//        hashMap.put(311, "苹果");
//        hashMap.put(312, "橘子");
//        hashMap.put(313, "菠萝");
//        hashMap.put(314, "水果");
//        hashMap.put(321, "苹果");
//        hashMap.put(322, "橘子");
//        hashMap.put(323, "菠萝");
//        hashMap.put(324, "水果");
        printHashMap(hashMap);
    }

    private void printHashMap(HashMap<Integer, String> hashMap) {
        HashSet<HashMap<Integer, String>.Entry<Integer, String>> entryHashSet = hashMap.entrySet();
        for (HashMap<Integer, String> .Entry<Integer, String> entry: entryHashSet) {
            logger.debug("key = {}, value = {}", entry.getKey(), entry.getValue());
        }
    }

}
