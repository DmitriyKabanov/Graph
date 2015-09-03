package com.sample.graph.exception;

public class VertexNotFoundException extends RuntimeException {
    public VertexNotFoundException(String vertexDetails) {
        super("Vertex: " + vertexDetails + " you're trying to access does not exist in the graph");
    }
}
