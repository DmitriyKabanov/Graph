package com.sample.graph.search;

import com.sample.graph.Graph;
import com.sample.graph.UndirectedGraph;
import com.sample.graph.model.Edge;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class DFSearchStrategyTest {
    private Graph<Integer> graph;

    private DFSearcher<Integer> searcher = new DFSearcher<>();

    @Before
    public void setUp() {
        initMocks(this);

        graph = new UndirectedGraph<>();
        populateGraph(1, 2, 3, 4, 5);
    }

    @Test
    @Ignore
    public void shouldReturnEmptyListIfSourceVertexHasNoEdges() {
        //Given

        //When
        List<Edge<Integer>> result = searcher.search(graph, 1, 5);

        //Then
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    @Ignore
    public void shouldReturnSingleEdgeIfSourceVertexHasDirectEdge() {
        //Given
        graph.addEdge(1, 5);

        //When
        List<Edge<Integer>> result = searcher.search(graph, 1, 5);

        //Then
        assertPathBetweenVertices(result, 1, 5, 1);
    }

    @Test
    public void shouldReturnEdgeListIfSourceVertexHasPathToTargetVertex() {
        //Given
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        //When
        List<Edge<Integer>> result = searcher.search(graph, 1, 5);

        //Then
        assertPathBetweenVertices(result, 1, 5, 3);
    }

    private void assertPathBetweenVertices(List<Edge<Integer>> edges, Integer sourceVertex, Integer targetVertex, int expectedPathSize) {
        assertEquals(expectedPathSize, edges.size());
        assertEquals(sourceVertex, edges.get(0).getSourceVertex());
        assertEquals(targetVertex, edges.get(expectedPathSize - 1).getTargetVertex());
    }

    private void populateGraph(Integer... vertices) {
        for (Integer vertex : vertices) {
            graph.addVertex(vertex);
        }
    }
}
