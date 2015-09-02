package com.sample.exception;

public class VertexNotFoundException extends RuntimeException {
    public VertexNotFoundException() {
        super("Vertex not found in the graph");
    }
}
