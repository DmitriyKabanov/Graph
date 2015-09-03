package com.sample.graph;

import com.sample.graph.model.SimpleEdge;

public class UndirectedGraph<T> extends AbstractGraph<T> {
    @Override
    public void addEdge(T sourceVertex, T targetVertex) {
        edgesOf(sourceVertex).add(new SimpleEdge<>(sourceVertex, targetVertex));
        edgesOf(targetVertex).add(new SimpleEdge<>(targetVertex, sourceVertex));
    }
}
