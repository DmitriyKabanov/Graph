package com.sample.search;

import com.sample.graph.Graph;
import com.sample.model.Edge;

import java.util.List;

public interface SearchStrategy<T> {
    List<Edge<T>> search(Graph<T> graph, T sourceVertex, T targetVertex);
}
