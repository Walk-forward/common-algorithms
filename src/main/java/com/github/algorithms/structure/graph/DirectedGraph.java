package com.github.algorithms.structure.graph;

import com.github.algorithms.structure.hash.HashMap;
import com.github.algorithms.structure.queue.Queue;
import com.github.algorithms.structure.set.HashSet;

import java.util.function.BiConsumer;

/**
 * 有向图
 * @param <T> 定点
 */
public class DirectedGraph<T> {

    /**
     * 图
     */
    private final HashMap<T, HashSet<T>> graph;

    public DirectedGraph() {
        graph = new HashMap<>();
    }

    /**
     * 向图中添加元素
     * @param node 定点
     * @param nodes 定点集
     */
    public void put(T node, T[] nodes) {
        HashSet<T> set = this.graph.get(node);
        if (set == null) {
            set = new HashSet<>();
            this.graph.put(node, set);
        }
        for (T t : nodes) {
            set.add(t);
        }
    }

    public void forEach(BiConsumer<? super T, ? super HashSet<T>> action) {
        graph.forEach(action);
    }

    /**
     * 广度优先搜索
     * @param searchNode 搜索节点
     * @return boolean
     */
    public boolean breadthFirstSearch(T searchNode) {
        Queue<T> queue = new Queue<>();
        HashMap<T, Boolean> hashMap = new HashMap<>();
        graph.forEach((t, ts) -> {
            queue.push(t);
            hashMap.put(t, true);
        });
        while (queue.getSize() != 0) {
            T node = queue.pop();
            if (node == null) {
                break;
            }
            if (searchNode.equals(node)) {
                return true;
            }else {
                HashSet<T> hashSet = graph.get(node);
                if (hashSet == null) {
                    continue;
                }
                hashSet.forEach(t -> {
                    if (null == hashMap.get(t)) {
                        queue.push(t);
                        hashMap.put(t, true);
                    }
                });
            }
        }
        return false;
    }
}
