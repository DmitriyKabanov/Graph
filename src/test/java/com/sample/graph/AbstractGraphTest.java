package com.sample.graph;

import com.sample.graph.exception.VertexNotFoundException;
import com.sample.graph.model.Edge;
import com.sample.graph.model.SimpleEdge;
import com.sample.graph.search.SearchStrategy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AbstractGraphTest extends BaseGraphTest {
    @Mock
    private SearchStrategy<Integer> mockedSearchStrategy;

    @Before
    public void setUp() {
        initMocks(this);
        graph = new AbstractGraph<Integer>() {
            @Override
            public void addEdge(Integer sourceVertex, Integer targetVertex) {
                edgesOf(sourceVertex).add(new SimpleEdge<>(sourceVertex, targetVertex));
            }
        };
    }

    @Test(expected = VertexNotFoundException.class)
    public void shouldThrowVertexNotFoundException() {
        graph.edgesOf(1);
    }

    @Test
    public void shouldReturnSetOfEdges() {
        //Given
        populateGraph(SOURCE_VERTEX, TARGET_VERTEX);
        graph.addEdge(SOURCE_VERTEX, TARGET_VERTEX);

        //When
        Set<Edge<Integer>> edges = graph.edgesOf(SOURCE_VERTEX);

        //Then
        assertEquals(1, edges.size());
        assertEquals(TARGET_VERTEX, edges.iterator().next().getTargetVertex());
    }

    @Test
    public void shouldReturnEmptySetOfEdges() {
        //Given
        populateGraph(SOURCE_VERTEX);

        //When
        Set<Edge<Integer>> edges = graph.edgesOf(SOURCE_VERTEX);

        //Then
        assertEquals(0, edges.size());
        assertEquals(Collections.emptySet(), edges);
    }

    @Test
    public void shouldGetPathBetweenTwoVertices() {
        //Given
        graph.setStrategy(mockedSearchStrategy);

        //When
        graph.getPath(SOURCE_VERTEX, TARGET_VERTEX);

        //Then
        verify(mockedSearchStrategy, times(1)).search(graph, SOURCE_VERTEX, TARGET_VERTEX);
    }
}
