package com.sample.graph;

import com.sample.model.Edge;
import com.sample.search.SearchStrategy;

import java.util.List;
import java.util.Set;

public interface Graph<T> {
    void addVertex(T vertex);
    void addEdge(T sourceVertex, T targetVertex);
    List<Edge<T>> getPath(T sourceVertex, T targetVertex);
    Set<Edge<T>> edgesOf(T vertex);
    void setStrategy(SearchStrategy<T> searchStrategy);
}
