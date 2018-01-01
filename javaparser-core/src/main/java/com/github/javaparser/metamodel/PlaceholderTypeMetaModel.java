package com.github.javaparser.metamodel;

import java.util.Optional;

public class PlaceholderTypeMetaModel extends TypeMetaModel {

    PlaceholderTypeMetaModel(Optional<BaseNodeMetaModel> superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, com.github.javaparser.ast.type.PlaceholderType.class, "PlaceholderType", "com.github.javaparser.ast.type", false, false);
    }

    public PropertyMetaModel placeholderKeyPropertyMetaModel;
}
