package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.SimpleName;

import java.util.Optional;

/**
 * Marks a node that is, or may act as a placeholder.
 */
public interface NodeWithPlaceholderKey<T extends Node> {
    Optional<SimpleName> getPlaceholderKey();

    T setPlaceholderKey(SimpleName key);

    default Optional<String> getPlaceholderKeyAsString() {
        return getPlaceholderKey().map(SimpleName::getIdentifier);
    }
}
