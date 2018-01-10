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
import com.github.javaparser.ast.nodeTypes.NodeWithIdentifier;
import com.github.javaparser.ast.nodeTypes.NodeWithOptionalPlaceholderKey;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.NonEmptyProperty;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.metamodel.SimpleNameMetaModel;
import javax.annotation.Generated;
import java.util.Optional;
import static com.github.javaparser.utils.Utils.assertNonEmpty;

/**
 * A name that consists of a single identifier.
 * In other words: it.does.NOT.contain.dots.
 *
 * @see Name
 */
public final class SimpleName extends Node implements NodeWithIdentifier<SimpleName>, NodeWithOptionalPlaceholderKey<SimpleName> {

    @NonEmptyProperty
    private String identifier;

    @OptionalProperty
    private SimpleName placeholderKey;

    public SimpleName() {
        this(null, "empty", null);
    }

    public SimpleName(final String identifier) {
        this(null, identifier, null);
    }

    @AllFieldsConstructor
    public SimpleName(final String identifier, SimpleName placeholderKey) {
        this(null, identifier, placeholderKey);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public SimpleName(TokenRange tokenRange, String identifier, SimpleName placeholderKey) {
        super(tokenRange);
        setIdentifier(identifier);
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
    public String getIdentifier() {
        return identifier;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public SimpleName setIdentifier(final String identifier) {
        assertNonEmpty(identifier);
        if (identifier == this.identifier) {
            return (SimpleName) this;
        }
        notifyPropertyChange(ObservableProperty.IDENTIFIER, this.identifier, identifier);
        this.identifier = identifier;
        return this;
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

    public String asString() {
        return identifier;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public SimpleName clone() {
        return (SimpleName) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public SimpleNameMetaModel getMetaModel() {
        return JavaParserMetaModel.simpleNameMetaModel;
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

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Optional<SimpleName> getPlaceholderKey() {
        return Optional.ofNullable(placeholderKey);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public SimpleName setPlaceholderKey(final SimpleName placeholderKey) {
        if (placeholderKey == this.placeholderKey) {
            return (SimpleName) this;
        }
        notifyPropertyChange(ObservableProperty.PLACEHOLDER_KEY, this.placeholderKey, placeholderKey);
        if (this.placeholderKey != null)
            this.placeholderKey.setParentNode(null);
        this.placeholderKey = placeholderKey;
        setAsParentNodeOf(placeholderKey);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public SimpleName removePlaceholderKey() {
        return setPlaceholderKey((SimpleName) null);
    }

}
