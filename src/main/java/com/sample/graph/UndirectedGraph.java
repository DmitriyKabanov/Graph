package com.sample.graph;

import com.sample.model.SimpleEdge;

public class UndirectedGraph<T> extends AbstractGraph<T> {
    @Override
    public void addEdge(T sourceVertex, T targetVertex) {
        edgesOf(sourceVertex).add(new SimpleEdge<>(targetVertex));
        edgesOf(targetVertex).add(new SimpleEdge<>(sourceVertex));
    }
}
