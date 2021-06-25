package com.github.algorithms.structure.hash;

import com.github.algorithms.structure.array.ArrayList;

/**
 * 散列表
 * @param <K> 键
 * @param <V> 值
 */
public class HashMap<K,V> {

    /**
     * 桶
     */
    private ArrayList<Node> barrel;

    /**
     * 桶大小
     */
    private int barrelSize = 16;

    public HashMap() {
        this.barrel = new ArrayList<>(this.barrelSize);
    }

    /**
     * 散列函数
     * @param key 键
     * @return 键取余桶大小
     */
    private int hashFunction(K key) {
        return (int)key % barrelSize;
    }

    /**
     * 将节点放入散列表
     * @param key 键
     * @param value 值
     */
    public void put(K key, V value) {
        Node node = new Node(key, value);
        barrel.set(hashFunction(key), node);
    }

    /**
     * 根据key取出节点值，如果不存在该节点则返回null
     * @param key 键
     * @return 值
     */
    public V get(K key) {
        Node node = barrel.get(hashFunction(key));
        if (node == null) {
            return null;
        }
        return node.v;
    }

    /**
     * 节点
     */
    private class Node {

        /**
         * 键
         */
        private K k;

        /**
         * 值
         */
        private V v;

        private Node node;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}
