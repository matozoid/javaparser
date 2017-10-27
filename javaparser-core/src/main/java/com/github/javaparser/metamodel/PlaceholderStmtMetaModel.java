package com.github.javaparser.metamodel;

import java.util.Optional;

public class PlaceholderStmtMetaModel extends StatementMetaModel {

    PlaceholderStmtMetaModel(Optional<BaseNodeMetaModel> superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.stmt.PlaceholderStmt.class, "PlaceholderStmt", "com.github.javaparser.ast.stmt", false, false);
    }

    public PropertyMetaModel labelPropertyMetaModel;
}
