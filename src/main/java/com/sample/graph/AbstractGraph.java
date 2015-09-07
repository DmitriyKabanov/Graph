package com.sample.graph;

import com.sample.graph.exception.VertexNotFoundException;
import com.sample.graph.model.Edge;
import com.sample.graph.search.DFSearcher;

import java.util.*;

public abstract class AbstractGraph<T> implements Graph<T> {
    private final Map<T, Set<Edge<T>>> adjacency = new HashMap<>();

    @Override
    public void addVertex(T vertex) {
        if (isVertexNotExists(vertex)) {
            adjacency.put(vertex, new HashSet<Edge<T>>());
        }
    }

    @Override
    public List<Edge<T>> getPath(T sourceVertex, T targetVertex) {
        if (isVertexNotExists(sourceVertex) || isVertexNotExists(targetVertex)) {
            throw new VertexNotFoundException("Both vertices must exist in the graph to find path between them");
        }
        return new DFSearcher<T>().search(this, sourceVertex, targetVertex);
    }

    @Override
    public Set<Edge<T>> edgesOf(T vertex) {
        if (isVertexNotExists(vertex)) {
            throw new VertexNotFoundException("Vertex: " + vertex + " you're trying to get edges of, does not exist in the graph");
        }
        return adjacency.get(vertex);
    }

    private boolean isVertexNotExists(T vertex) {
        return !adjacency.containsKey(vertex);
    }
}
