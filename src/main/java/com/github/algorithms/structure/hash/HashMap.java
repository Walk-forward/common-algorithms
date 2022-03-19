package com.github.algorithms.structure.hash;

import com.github.algorithms.structure.array.ArrayList;
import com.github.algorithms.structure.linked.LinkedList;
import com.github.algorithms.structure.set.HashSet;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * 散列表
 * @param <K> 键
 * @param <V> 值
 */
public class HashMap<K,V> {

    /**
     * 桶
     */
    private ArrayList<LinkedList<Node<K,V>>> barrel;

    /**
     * 桶大小
     */
    private int barrelSize;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 装载因子
     */
    private final double loadFactor;

    public HashMap() {
        this(16);
    }

    /**
     * 创建指定桶大小的散列表
     * @param barrelSize 桶大小
     */
    public HashMap(int barrelSize) {
        this(barrelSize, 0.75);
    }

    /**
     * 创建指定桶大小和装载因子的散列表
     * @param barrelSize 桶大小
     * @param loadFactor 装载因子
     */
    public HashMap(int barrelSize, double loadFactor) {
        if (barrelSize < 16) {
            barrelSize = 16;
        }else {
            final int MAXIMUM_CAPACITY = 1 << 30;
            int n = -1 >>> Integer.numberOfLeadingZeros(barrelSize - 1);
            barrelSize = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }
        this.barrelSize = barrelSize;
        this.loadFactor = loadFactor;
        this.barrel = new ArrayList<>(this.barrelSize);
    }

    /**
     * 散列函数
     * @param key 键
     * @return 键取余桶大小
     */
    private int hashFunction(K key) {
        return key.hashCode() % barrelSize;
    }

    /**
     * 元素数量
     * @return 元素数量
     */
    private int size() {
        return this.size;
    }

    /**
     * 将节点放入散列表
     * @param key 键
     * @param value 值
     */
    public void put(K key, V value) {
        Node<K,V> newNode = new Node<>(key, value);
        int hashCode = hashFunction(key);
        LinkedList<Node<K,V>> linkedList = barrel.get(hashCode);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            barrel.set(hashCode, linkedList);
        }
        boolean f = true;
        Iterator<Node<K,V>> iterator = linkedList.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Node<K,V> node = iterator.next();
            if (node.k.equals(newNode.k)) {
                linkedList.set(i, newNode);
                f = false;
                break;
            }
        }
        if (f) {
            linkedList.insert(newNode);
            if ((double)size / barrelSize > loadFactor) {
                barrelSize = barrelSize * 2;
                rehashed();
            }
            this.size ++;
        }
    }

    /**
     * 再散列
     */
    private void rehashed() {
        HashMap<K, V> hashMap = new HashMap<>(this.barrelSize, this.loadFactor);
        HashSet<Entry<K, V>> entries = entrySet();
        entries.forEach(e -> hashMap.put(e.getKey(), e.getValue()));
        barrel = hashMap.barrel;
    }

    /**
     * 根据key取出节点值，如果不存在该节点则返回null
     * @param key 键
     * @return 值
     */
    public V get(K key) {
        int hashCode = hashFunction(key);
        LinkedList<Node<K,V>> linkedList = barrel.get(hashCode);
        if (linkedList == null) {
            return null;
        }
        for (Node<K,V> node :linkedList) {
            if (node.k.equals(key)) {
                return node.v;
            }
        }
        return null;
    }

    public HashSet<HashMap.Entry<K, V>> entrySet() {
        HashSet<HashMap.Entry<K, V>> hashSet = new HashSet<>();
        barrel.forEach(linkedList -> {
            if (linkedList != null) {
                linkedList.forEach(kvNode -> {
                    Entry<K, V> entry = new Entry<>(kvNode.k, kvNode.v);
                    hashSet.add(entry);
                });
            }
        });
        return hashSet;
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (Entry<K, V> entry : entrySet()) {
            action.accept(entry.getKey(), entry.getValue());
        }
    }

    public static class Entry<K1, V1> {

        /**
         * 键
         */
        private final K1 k;

        /**
         * 值
         */
        private final V1 v;

        public Entry(K1 k, V1 v) {
            this.k = k;
            this.v = v;
        }

        public K1 getKey() {
            return k;
        }

        public V1 getValue() {
            return v;
        }

    }

    /**
     * 节点
     */
    private record Node<K1, V1>(K1 k, V1 v) {

    }
}
