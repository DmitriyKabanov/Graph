package com.sample.graph.exception;

public class VertexNotFoundException extends RuntimeException {
    public VertexNotFoundException(Object vertex) {
        super("Vertex: " + vertex + " you're trying to access does not exist in the graph");
    }
}
