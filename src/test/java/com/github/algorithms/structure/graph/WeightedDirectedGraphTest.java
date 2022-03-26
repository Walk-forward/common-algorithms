package com.github.algorithms.structure.graph;

import com.github.algorithms.structure.hash.HashMap;
import com.github.algorithms.structure.linked.LinkedList;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WeightedDirectedGraphTest {

    Logger logger = LoggerFactory.getLogger(WeightedDirectedGraphTest.class);

    @Test
    public void breadthFirstSearch() {
        WeightedDirectedGraph<String> weightedDirectedGraph = new WeightedDirectedGraph<>();
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        hashMap1.put("A", 6);
        hashMap1.put("B", 2);
        weightedDirectedGraph.put("1", hashMap1);

        HashMap<String, Integer> hashMapA = new HashMap<>();
        hashMapA.put("2", 1);
        weightedDirectedGraph.put("A", hashMapA);

        HashMap<String, Integer> hashMapB = new HashMap<>();
        hashMapB.put("A", 3);
        hashMapB.put("2", 5);
        weightedDirectedGraph.put("B", hashMapB);

        weightedDirectedGraph.put("2", null);

        LinkedList<WeightedDirectedGraph<String>.ShortestPath> shortestPaths = weightedDirectedGraph.breadthFirstSearch("1", "2");
        StringBuilder builder = new StringBuilder();
        shortestPaths.forEach(shortestPath ->
                builder.append("-> ").append(shortestPath.node).append("[").append(shortestPath.length).append("] ")
        );
        logger.debug(builder.toString());
    }
}