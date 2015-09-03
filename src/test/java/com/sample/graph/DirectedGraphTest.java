package com.sample.graph;

import com.sample.graph.model.Edge;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DirectedGraphTest extends BaseGraphTest {

    @Before
    public void setUp() {
        graph = new DirectedGraph<>();
    }

    @Test
    public void shouldAddEdgeToGraph() {
        //Given
        populateGraph(SOURCE_VERTEX, TARGET_VERTEX);

        //When
        graph.addEdge(SOURCE_VERTEX, TARGET_VERTEX);

        //Then
        Set<Edge<Integer>> edges = graph.edgesOf(SOURCE_VERTEX);
        assertEquals(1, edges.size());
        assertEquals(TARGET_VERTEX, edges.iterator().next().getTargetVertex());
    }
}
