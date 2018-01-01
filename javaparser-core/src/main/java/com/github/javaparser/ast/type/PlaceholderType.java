/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2016 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
package com.github.javaparser.ast.type;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.resolution.types.ResolvedType;
import javax.annotation.Generated;
import java.util.Optional;
import java.util.function.Consumer;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.PlaceholderTypeMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;

/**
 * A general purpose placeholder. This is not valid Java syntax. It is created by inserting a backslash and a name where an
 * expression would normally be.
 */
public final class PlaceholderType extends Type implements NodeWithSimpleName<PlaceholderType> {

    @OptionalProperty
    private SimpleName placeholderKey;

    public PlaceholderType() {
        this(null, new SimpleName());
    }

    public PlaceholderType(final String placeholderKey) {
        this(null, new SimpleName(placeholderKey));
    }

    @AllFieldsConstructor
    public PlaceholderType(final SimpleName placeholderKey) {
        this(null, placeholderKey);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public PlaceholderType(TokenRange tokenRange, SimpleName placeholderKey) {
        super(tokenRange);
        setPlaceholderKey(placeholderKey);
        customInitialization();
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
        return v.visit(this, arg);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <A> void accept(final VoidVisitor<A> v, final A arg) {
        v.visit(this, arg);
    }

    @Override
    public String asString() {
        return "`" + placeholderKey.asString() + "`";
    }

    @Override
    public ResolvedType resolve() {
        return null;
    }

    @Override
    public SimpleName getName() {
        return placeholderKey;
    }

    @Override
    public PlaceholderType setName(SimpleName name) {
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isPlaceholderType() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public PlaceholderType asPlaceholderType() {
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public Optional<PlaceholderType> toPlaceholderType() {
        return Optional.of(this);
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifPlaceholderType(Consumer<PlaceholderType> action) {
        action.accept(this);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Optional<SimpleName> getPlaceholderKey() {
        return Optional.ofNullable(placeholderKey);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public PlaceholderType setPlaceholderKey(final SimpleName placeholderKey) {
        if (placeholderKey == this.placeholderKey) {
            return (PlaceholderType) this;
        }
        notifyPropertyChange(ObservableProperty.PLACEHOLDER_KEY, this.placeholderKey, placeholderKey);
        if (this.placeholderKey != null)
            this.placeholderKey.setParentNode(null);
        this.placeholderKey = placeholderKey;
        setAsParentNodeOf(placeholderKey);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public PlaceholderType removePlaceholderKey() {
        return setPlaceholderKey((SimpleName) null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        if (placeholderKey != null) {
            if (node == placeholderKey) {
                removePlaceholderKey();
                return true;
            }
        }
        return super.remove(node);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (placeholderKey != null) {
            if (node == placeholderKey) {
                setPlaceholderKey((SimpleName) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public PlaceholderType clone() {
        return (PlaceholderType) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public PlaceholderTypeMetaModel getMetaModel() {
        return JavaParserMetaModel.placeholderTypeMetaModel;
    }
}
