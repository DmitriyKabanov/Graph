package com.sample.search;

import com.sample.graph.Graph;
import com.sample.model.Edge;

import java.util.*;

public class DFSearchStrategy<T> implements SearchStrategy<T> {
    private final Set<T> visitedVertices = new HashSet<>();

    @Override
    public List<Edge<T>> search(Graph<T> graph, T sourceVertex, T targetVertex) {
        visitedVertices.clear();
        visitedVertices.add(sourceVertex);
        return dfs(graph, sourceVertex, targetVertex, new LinkedList<Edge<T>>());
    }

    private List<Edge<T>> dfs(Graph<T> graph, T sourceVertex, T targetVertex, List<Edge<T>> path) {
        Set<Edge<T>> edges = graph.edgesOf(sourceVertex);
        for (Edge<T> edge : edges) {
            T vertex = edge.getTargetVertex();

            if (visitedVertices.contains(vertex)) {
                continue;
            }

            if (targetVertex.equals(vertex)) {
                path.add(edge);
                return path;
            } else if (graph.edgesOf(vertex).size() > 0) {
                path.add(edge);
                visitedVertices.add(vertex);
                return dfs(graph, vertex, targetVertex, path);
            }
        }
        return Collections.emptyList();
    }
}
