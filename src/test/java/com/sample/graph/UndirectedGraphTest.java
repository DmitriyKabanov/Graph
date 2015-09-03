package com.sample.graph;

import com.sample.graph.model.Edge;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UndirectedGraphTest extends BaseGraphTest {

    @Before
    public void setUp() {
        graph = new UndirectedGraph<>();
    }

    @Test
    public void shouldAddEdgeToGraph() {
        //Given
        populateGraph(SOURCE_VERTEX, TARGET_VERTEX);

        //When
        graph.addEdge(SOURCE_VERTEX, TARGET_VERTEX);

        //Then
        Set<Edge<Integer>> sourceVertexEdges = graph.edgesOf(SOURCE_VERTEX);
        Set<Edge<Integer>> targetVertexEdges = graph.edgesOf(TARGET_VERTEX);

        assertEquals(1, sourceVertexEdges.size());
        assertEquals(1, targetVertexEdges.size());

        assertEquals(sourceVertexEdges.iterator().next().getTargetVertex(), TARGET_VERTEX);
        assertEquals(targetVertexEdges.iterator().next().getTargetVertex(), SOURCE_VERTEX);
    }
}
