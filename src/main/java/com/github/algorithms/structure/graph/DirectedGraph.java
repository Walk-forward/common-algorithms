package com.github.algorithms.structure.graph;

import com.github.algorithms.structure.hash.HashMap;
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
}
