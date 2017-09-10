package com.github.javaparser.metamodel;

import java.util.Optional;

public class UnparsableExprMetaModel extends ExpressionMetaModel {

    UnparsableExprMetaModel(Optional<BaseNodeMetaModel> superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.UnparsableExpr.class, "UnparsableExpr", "com.github.javaparser.ast.expr", false, false);
    }
}
