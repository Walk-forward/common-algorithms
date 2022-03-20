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
     * @param rootNode 起始节点
     * @param searchNode 搜索值
     * @return 距离，没有找到 = -1
     */
    public int breadthFirstSearch(T rootNode, T searchNode) {
        if (rootNode == searchNode) {
            return 0;
        }
        Queue<T> queue = new Queue<>();
        HashMap<T, Integer> hashMap = new HashMap<>();
        HashSet<T> ts1 = graph.get(rootNode);
        if (ts1 != null) {
            ts1.forEach(t -> {
                queue.push(t);
                hashMap.put(t, 1);
            });
        }
        while (queue.getSize() != 0) {
            T node = queue.pop();
            if (searchNode.equals(node)) {
                return hashMap.get(node);
            }else {
                HashSet<T> hashSet = graph.get(node);
                if (hashSet == null) {
                    continue;
                }
                Integer distance = hashMap.get(node);
                hashSet.forEach(t -> {
                    if (null == hashMap.get(t)) {
                        queue.push(t);
                        hashMap.put(t, distance + 1);
                    }
                });
            }
        }
        return -1;
    }
}
