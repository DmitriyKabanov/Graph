package com.sample.graph.search;

import com.sample.graph.Graph;
import com.sample.graph.model.Edge;

import java.util.*;

public class DFSearcher<T> {
    private final Set<T> visitedVertices = new HashSet<>();

    public List<Edge<T>> search(Graph<T> graph, T sourceVertex, T targetVertex) {
        visitedVertices.clear();
        visitedVertices.add(sourceVertex);
        return dfs(graph, sourceVertex, targetVertex, new LinkedList<Edge<T>>());
    }

    private List<Edge<T>> dfs(Graph<T> graph, T sourceVertex, T targetVertex, List<Edge<T>> path) {
        for (Edge<T> edge : graph.edgesOf(sourceVertex)) {
            T vertex = edge.getTargetVertex();
            if (visitedVertices.contains(vertex)) {
                continue;
            }

            if (targetVertex.equals(vertex)) {
                path.add(edge);
                return path;
            } else if(hasUnvisitedChild(graph, vertex)) {
                path.add(edge);
                visitedVertices.add(vertex);
                return dfs(graph, vertex, targetVertex, path);
            }
        }
        return Collections.emptyList();
    }

    private boolean hasUnvisitedChild(Graph<T> graph, T vertex) {
        for (Edge<T> edge : graph.edgesOf(vertex)) {
            if (!visitedVertices.contains(edge.getTargetVertex())) {
                return true;
            }
        }
        return false;
    }
}
