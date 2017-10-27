package com.github.javaparser.metamodel;

import java.util.Optional;

public class PlaceholderExprMetaModel extends ExpressionMetaModel {

    PlaceholderExprMetaModel(Optional<BaseNodeMetaModel> superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.expr.PlaceholderExpr.class, "PlaceholderExpr", "com.github.javaparser.ast.expr", false, false);
    }

    public PropertyMetaModel namePropertyMetaModel;
}
