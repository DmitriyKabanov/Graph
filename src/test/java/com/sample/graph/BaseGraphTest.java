package com.sample.graph;

public class BaseGraphTest {
    protected static final Integer INVALID_VERTEX = 0;
    protected static final Integer SOURCE_VERTEX  = 1;
    protected static final Integer TARGET_VERTEX  = 2;

    protected Graph<Integer> graph;

    protected void populateGraph(Integer... vertices) {
        for (Integer vertex : vertices) {
            graph.addVertex(vertex);
        }
    }
}
