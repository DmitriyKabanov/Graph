package com.sample.graph.model;

public class SimpleEdge<T> implements Edge<T> {
    private final T sourceVertex;
    private final T targetVertex;

    public SimpleEdge(T sourceVertex, T targetVertex) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
    }

    @Override
    public T getSourceVertex() {
        return sourceVertex;
    }

    @Override
    public T getTargetVertex() {
        return targetVertex;
    }
}
