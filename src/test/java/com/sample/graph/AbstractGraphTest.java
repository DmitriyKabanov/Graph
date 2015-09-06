package com.sample.graph;

import com.sample.graph.exception.VertexNotFoundException;
import com.sample.graph.model.Edge;
import com.sample.graph.model.SimpleEdge;
import com.sample.graph.search.DFSearcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AbstractGraph.class)
public class AbstractGraphTest extends BaseGraphTest {

    @Mock
    private DFSearcher<Integer> mockedSearcher;

    @Before
    public void setUp() throws Exception {
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
        try {
            graph.edgesOf(INVALID_VERTEX);
        } catch (VertexNotFoundException exception){
            assertEquals("Vertex: " + INVALID_VERTEX + " you're trying to access does not exist in the graph", exception.getMessage());
            throw exception;
        }

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
    public void shouldGetPathBetweenTwoVertices() throws Exception {
        //Given
        whenNew(DFSearcher.class).withNoArguments().thenReturn(mockedSearcher);

        //When
        graph.getPath(SOURCE_VERTEX, TARGET_VERTEX);

        //Then
        verifyNew(DFSearcher.class).withNoArguments();
        verify(mockedSearcher, times(1)).search(graph, SOURCE_VERTEX, TARGET_VERTEX);
    }
}
