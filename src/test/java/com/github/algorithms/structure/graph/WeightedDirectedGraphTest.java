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
        assert "-> B[2] -> A[3] -> 2[1] ".equals(builder.toString());
        breadthFirstSearchA();
        breadthFirstSearchChangeThePiano();
    }

    private void breadthFirstSearchA() {
        WeightedDirectedGraph<String> weightedDirectedGraph = new WeightedDirectedGraph<>();
        HashMap<String, Integer> hashMapStartingPoint = new HashMap<>();
        hashMapStartingPoint.put("A", 5);
        hashMapStartingPoint.put("B", 2);
        weightedDirectedGraph.put("起点", hashMapStartingPoint);

        HashMap<String, Integer> hashMapA = new HashMap<>();
        hashMapA.put("C", 4);
        hashMapA.put("D", 2);
        weightedDirectedGraph.put("A", hashMapA);

        HashMap<String, Integer> hashMapB = new HashMap<>();
        hashMapB.put("A", 8);
        hashMapB.put("D", 7);
        weightedDirectedGraph.put("B", hashMapB);

        HashMap<String, Integer> hashMapC = new HashMap<>();
        hashMapC.put("终点", 3);
        hashMapC.put("D", 6);
        weightedDirectedGraph.put("C", hashMapC);

        HashMap<String, Integer> hashMapD = new HashMap<>();
        hashMapD.put("终点", 1);
        weightedDirectedGraph.put("D", hashMapD);

        weightedDirectedGraph.put("终点", null);

        LinkedList<WeightedDirectedGraph<String>.ShortestPath> shortestPaths = weightedDirectedGraph.breadthFirstSearch("起点", "终点");
        StringBuilder builder = new StringBuilder();
        shortestPaths.forEach(shortestPath ->
                builder.append("-> ").append(shortestPath.node).append("[").append(shortestPath.length).append("] ")
        );
        logger.debug(builder.toString());
        assert "-> A[5] -> D[2] -> 终点[1] ".equals(builder.toString());
    }

    private void breadthFirstSearchChangeThePiano() {
        WeightedDirectedGraph<String> weightedDirectedGraph = new WeightedDirectedGraph<>();
        HashMap<String, Integer> hashMapSheetMusic = new HashMap<>();
        hashMapSheetMusic.put("稀有的黑胶唱片", 5);
        hashMapSheetMusic.put("海报", 0);
        weightedDirectedGraph.put("乐谱", hashMapSheetMusic);

        HashMap<String, Integer> hashMapVinylRecords = new HashMap<>();
        hashMapVinylRecords.put("低音吉他", 15);
        hashMapVinylRecords.put("架子鼓", 20);
        weightedDirectedGraph.put("稀有的黑胶唱片", hashMapVinylRecords);

        HashMap<String, Integer> hashMapPoster = new HashMap<>();
        hashMapPoster.put("低音吉他", 30);
        hashMapPoster.put("架子鼓", 35);
        weightedDirectedGraph.put("海报", hashMapPoster);

        HashMap<String, Integer> hashMapGuitar = new HashMap<>();
        hashMapGuitar.put("钢琴", 20);
        weightedDirectedGraph.put("低音吉他", hashMapGuitar);

        HashMap<String, Integer> hashMapDrumKit = new HashMap<>();
        hashMapDrumKit.put("钢琴", 10);
        weightedDirectedGraph.put("架子鼓", hashMapDrumKit);

        weightedDirectedGraph.put("钢琴", null);

        LinkedList<WeightedDirectedGraph<String>.ShortestPath> shortestPaths = weightedDirectedGraph.breadthFirstSearch("乐谱", "钢琴");
        StringBuilder builder = new StringBuilder();
        shortestPaths.forEach(shortestPath ->
                builder.append("-> ").append(shortestPath.node).append("[").append(shortestPath.length).append("] ")
        );
        logger.debug(builder.toString());
        assert "-> 稀有的黑胶唱片[5] -> 架子鼓[20] -> 钢琴[10] ".equals(builder.toString());
    }
}