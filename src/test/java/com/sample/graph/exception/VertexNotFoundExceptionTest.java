package com.sample.graph.exception;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VertexNotFoundExceptionTest {

    @Test
    public void shouldGenerateCorrectMessage() {
        Exception vertexNotFoundException = new VertexNotFoundException("Test Vertex Details");
        assertEquals("Vertex: Test Vertex Details you're trying to access does not exist in the graph", vertexNotFoundException.getMessage());
    }
}
