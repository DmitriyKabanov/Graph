package com.sample.model;

public class SimpleEdge<T> implements Edge<T> {
    private final T targetVertex;

    public SimpleEdge(T targetVertex) {
        this.targetVertex = targetVertex;
    }

    @Override
    public T getTargetVertex() {
        return targetVertex;
    }
}
