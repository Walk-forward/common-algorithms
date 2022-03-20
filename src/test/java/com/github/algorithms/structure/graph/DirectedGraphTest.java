package com.github.algorithms.structure.graph;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DirectedGraphTest {

    Logger logger = LoggerFactory.getLogger(DirectedGraphTest.class);

    @Test
    void put() {
        DirectedGraph<String> directedGraph = new DirectedGraph<>();
        String[] a = {"ALICE", "BOB", "CLAIRE"};
        directedGraph.put("你", a);

        String[] alice = {"PEGGY"};
        directedGraph.put("ALICE", alice);
        String[] bob = {"ANUJ", "PEGGY"};
        directedGraph.put("BOB", bob);
        String[] claire = {"JONNY", "THOM"};
        directedGraph.put("CLAIRE", claire);

        String[] anuj = {};
        directedGraph.put("ANUJ", anuj);
        String[] peggy = {};
        directedGraph.put("PEGGY", peggy);
        String[] jonny = {};
        directedGraph.put("JONNY", jonny);
        String[] thom = {};
        directedGraph.put("THOM", thom);

        directedGraph.forEach((s, strings) -> {
            logger.debug("nede = {}", s);
            strings.forEach(t -> logger.debug("\t nedes = {}", t));
            logger.debug("nede = {}, ------- end -------", s);
        });
    }

    @Test
    void breadthFirstSearch() {
        DirectedGraph<String> directedGraph = new DirectedGraph<>();
        String[] a = {"ALICE", "BOB", "CLAIRE"};
        directedGraph.put("你", a);

        String[] alice = {"PEGGY"};
        directedGraph.put("ALICE", alice);
        String[] bob = {"ANUJ", "PEGGY"};
        directedGraph.put("BOB", bob);
        String[] claire = {"JONNY", "THOM"};
        directedGraph.put("CLAIRE", claire);

        String[] anuj = {};
        directedGraph.put("ANUJ", anuj);
        String[] peggy = {};
        directedGraph.put("PEGGY", peggy);
        String[] jonny = {};
        directedGraph.put("JONNY", jonny);
        String[] thom = {};
        directedGraph.put("THOM", thom);

        int searchThom = directedGraph.breadthFirstSearch("你","THOM");
        assert searchThom == 2;

        int searchYou = directedGraph.breadthFirstSearch("你","你");
        assert searchYou == 0;

        int searchHello = directedGraph.breadthFirstSearch("你","你好");
        assert searchHello == -1;

        int searchClaire = directedGraph.breadthFirstSearch("CLAIRE","你");
        assert searchClaire == -1;

        int searchBob = directedGraph.breadthFirstSearch("BOB","PEGGY");
        assert searchBob == 1;
    }
}