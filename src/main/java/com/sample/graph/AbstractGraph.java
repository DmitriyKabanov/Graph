package com.sample.graph;

import com.sample.exception.VertexNotFoundException;
import com.sample.model.Edge;
import com.sample.search.SearchStrategy;

import java.util.*;

public abstract class AbstractGraph<T> implements Graph<T> {
    private final Map<T, Set<Edge<T>>> adjacency = new HashMap<>();
    private SearchStrategy<T> searchStrategy;

    @Override
    public void addVertex(T vertex) {
        if (!isVertexExists(vertex)) {
            adjacency.put(vertex, new HashSet<Edge<T>>());
        }
    }

    @Override
    public List<Edge<T>> getPath(T sourceVertex, T targetVertex) {
        return searchStrategy.search(this, sourceVertex, targetVertex);
    }

    @Override
    public Set<Edge<T>> edgesOf(T vertex) {
        if (!isVertexExists(vertex)) {
            throw new VertexNotFoundException(vertex.toString());
        }
        return adjacency.get(vertex);
    }

    @Override
    public void setStrategy(SearchStrategy<T> searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    private boolean isVertexExists(T vertex) {
        return adjacency.containsKey(vertex);
    }
}
