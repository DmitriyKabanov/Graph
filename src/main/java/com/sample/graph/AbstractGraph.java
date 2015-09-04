package com.sample.graph;

import com.sample.graph.exception.VertexNotFoundException;
import com.sample.graph.model.Edge;
import com.sample.graph.search.DFSearcher;

import java.util.*;

public abstract class AbstractGraph<T> implements Graph<T> {
    private final Map<T, Set<Edge<T>>> adjacency = new HashMap<>();

    @Override
    public void addVertex(T vertex) {
        if (!isVertexExists(vertex)) {
            adjacency.put(vertex, new HashSet<Edge<T>>());
        }
    }

    @Override
    public List<Edge<T>> getPath(T sourceVertex, T targetVertex) {
        return new DFSearcher<T>().search(this, sourceVertex, targetVertex);
    }

    @Override
    public Set<Edge<T>> edgesOf(T vertex) {
        if (!isVertexExists(vertex)) {
            throw new VertexNotFoundException(vertex.toString());
        }
        return adjacency.get(vertex);
    }

    private boolean isVertexExists(T vertex) {
        return adjacency.containsKey(vertex);
    }
}
