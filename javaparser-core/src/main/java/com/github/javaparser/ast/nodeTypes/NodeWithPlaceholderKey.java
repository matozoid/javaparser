package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.SimpleName;

import java.util.Optional;

/**
 * Marks a node that is a placeholder.
 */
public interface NodeWithPlaceholderKey<T extends Node> {
    SimpleName getPlaceholderKey();

    T setPlaceholderKey(SimpleName key);

    default String getPlaceholderKeyAsString() {
        return getPlaceholderKey().getIdentifier();
    }
}
