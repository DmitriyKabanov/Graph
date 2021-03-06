package com.sample.graph;

import com.sample.graph.model.Edge;

import java.util.List;
import java.util.Set;

public interface Graph<T> {
    void addVertex(T vertex);
    void addEdge(T sourceVertex, T targetVertex);
    List<Edge<T>> getPath(T sourceVertex, T targetVertex);
    Set<Edge<T>> edgesOf(T vertex);
}
