package com.sample.graph;

import com.sample.model.SimpleEdge;

public class DirectedGraph<T> extends AbstractGraph<T> {
    @Override
    public void addEdge(T sourceVertex, T targetVertex) {
        edgesOf(sourceVertex).add(new SimpleEdge<>(targetVertex));
    }
}
