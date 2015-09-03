package com.sample.graph.model;

public interface Edge<T> {
    T getSourceVertex();
    T getTargetVertex();
}
