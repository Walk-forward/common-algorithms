package com.github.algorithms.structure.graph;

import com.github.algorithms.structure.hash.HashMap;
import com.github.algorithms.structure.linked.LinkedList;
import com.github.algorithms.structure.queue.Queue;
import com.github.algorithms.structure.stack.Stack;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

/**
 * 加权有向图
 * @param <T> 顶点
 */
public class WeightedDirectedGraph<T> {

    /**
     * 图
     */
    private final HashMap<T, HashMap<T, Integer>> graph;

    public WeightedDirectedGraph() {
        this.graph = new HashMap<>();
    }

    /**
     * 向图中添加元素
     * @param node 顶点
     * @param nodes 顶点集
     */
    public void put(T node, HashMap<T, Integer> nodes) {
        HashMap<T, Integer> hashMap = this.graph.get(node);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.graph.put(node, hashMap);
        }
        if (nodes != null) {
            nodes.forEach(hashMap::put);
        }
    }

    public void forEach(BiConsumer<? super T, ? super HashMap<T, Integer>> action) {
        graph.forEach(action);
    }

    /**
     * 狄克斯特拉算法
     * @param startingPoint 起点
     * @param endPoint 终点
     * @return 起点或终点不在图中返回null
     */
    public LinkedList<ShortestPath> breadthFirstSearch(T startingPoint, T endPoint) {
        AtomicBoolean startingPointExists = new AtomicBoolean(false);
        AtomicBoolean endPointExists = new AtomicBoolean(false);
        graph.forEach((node, nodes) -> {
            if (node == startingPoint) {
                startingPointExists.set(true);
            }
            if (node == endPoint) {
                endPointExists.set(true);
            }
            nodes.forEach((node1, nodes1) -> {
                if (node1 == startingPoint) {
                    startingPointExists.set(true);
                }
                if (node1 == endPoint) {
                    endPointExists.set(true);
                }
            });
        });
        if (!(startingPointExists.get() && endPointExists.get())) {
            return null;
        }

        LinkedList<ShortestPath> linkedList = new LinkedList<>();
        if (startingPoint == endPoint) {
            linkedList.insert(new ShortestPath(startingPoint, 0));
            return linkedList;
        }

        Queue<T> queue = new Queue<>();
        // 费用
        HashMap<T, Integer> costs = new HashMap<>();
        // 父节点
        HashMap<T, T> parents = new HashMap<>();
        queue.push(startingPoint);
        while (!queue.isEmpty()) {
            T node = queue.pop();
            HashMap<T, Integer> hashMap = graph.get(node);
            hashMap.forEach((k, v) -> {
                Integer costsK = costs.get(k);
                if (costsK == null || v < costsK) {
                    costs.put(k, v);
                    parents.put(k, node);
                    queue.push(k);
                }
            });
        }

        Stack<ShortestPath> stack = new Stack<>();
        queue.push(endPoint);
        while (!queue.isEmpty()) {
            T node = queue.pop();
            Integer costsNode = costs.get(node);
            if (costsNode == null) {
                continue;
            }
            ShortestPath shortestPath = new ShortestPath(node, costsNode);
            stack.push(shortestPath);

            T parentsNode = parents.get(node);
            queue.push(parentsNode);
        }

        while (!stack.empty()) {
            linkedList.insert(stack.pop());
        }
        return linkedList;
    }

    public class ShortestPath {

        T node;
        Integer length;

        public ShortestPath(T node, int length) {
            this.node = node;
            this.length = length;
        }

    }
}
