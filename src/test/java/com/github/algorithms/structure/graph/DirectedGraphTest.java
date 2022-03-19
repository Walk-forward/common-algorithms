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
        directedGraph.put("PEGGY", jonny);
        String[] thom = {};
        directedGraph.put("THOM", thom);

        directedGraph.forEach((s, strings) -> {
            logger.debug("nede = {}", s);
            strings.forEach(t -> logger.debug("\t nedes = {}", t));
            logger.debug("nede = {}, ------- end -------", s);
        });
    }
}