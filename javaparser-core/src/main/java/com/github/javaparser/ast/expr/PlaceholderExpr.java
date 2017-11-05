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
package com.github.javaparser.ast.expr;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithPlaceholderKey;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import javax.annotation.Generated;
import java.util.Optional;
import java.util.function.Consumer;
import com.github.javaparser.metamodel.PlaceholderExprMetaModel;
import static com.github.javaparser.utils.Utils.assertNotNull;

/**
 * A general purpose placeholder. This is not Java syntax. It is created by inserting a backslash and a name where an
 * expression would normally be.
 */
public final class PlaceholderExpr extends Expression implements NodeWithPlaceholderKey<PlaceholderExpr> {

    private SimpleName placeholderKey;

    public PlaceholderExpr() {
        this(null, new SimpleName());
    }

    public PlaceholderExpr(final String placeholderKey) {
        this(null, new SimpleName(placeholderKey));
    }

    @AllFieldsConstructor
    public PlaceholderExpr(final SimpleName placeholderKey) {
        this(null, placeholderKey);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public PlaceholderExpr(TokenRange tokenRange, SimpleName placeholderKey) {
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

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Optional<SimpleName> getPlaceholderKey() {
        return Optional.ofNullable(placeholderKey);
    }

    /**
     * Sets the name
     *
     * @param label the name, can be null
     * @return this, the BreakStmt
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public PlaceholderExpr setPlaceholderKey(final SimpleName placeholderKey) {
        if (placeholderKey == this.placeholderKey) {
            return (PlaceholderExpr) this;
        }
        notifyPropertyChange(ObservableProperty.PLACEHOLDER_KEY, this.placeholderKey, placeholderKey);
        if (this.placeholderKey != null)
            this.placeholderKey.setParentNode(null);
        this.placeholderKey = placeholderKey;
        setAsParentNodeOf(placeholderKey);
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isPlaceholderExpr() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public PlaceholderExpr asPlaceholderExpr() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifPlaceholderExpr(Consumer<PlaceholderExpr> action) {
        action.accept(this);
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
    public PlaceholderExpr clone() {
        return (PlaceholderExpr) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public PlaceholderExprMetaModel getMetaModel() {
        return JavaParserMetaModel.placeholderExprMetaModel;
    }

    public PlaceholderExpr removePlaceholderKey() {
        return setPlaceholderKey((SimpleName) null);
    }
}
