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
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.resolution.types.ResolvedType;
import javax.annotation.Generated;
import static com.github.javaparser.utils.Utils.assertNotNull;
import java.util.function.Consumer;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.PlaceholderTypeMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;

/**
 * A general purpose placeholder. This is not Java syntax. It is created by inserting a backslash and a name where an
 * expression would normally be.
 */
public final class PlaceholderType extends Type implements NodeWithSimpleName<PlaceholderType> {

    private SimpleName name;

    public PlaceholderType() {
        this(null, new SimpleName());
    }

    public PlaceholderType(final String name) {
        this(null, new SimpleName(name));
    }

    @AllFieldsConstructor
    public PlaceholderType(final SimpleName name) {
        this(null, name);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public PlaceholderType(TokenRange tokenRange, SimpleName name) {
        super(tokenRange);
        setName(name);
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
    public SimpleName getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param label the name, can be null
     * @return this, the BreakStmt
     */
    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public PlaceholderType setName(final SimpleName name) {
        assertNotNull(name);
        if (name == this.name) {
            return (PlaceholderType) this;
        }
        notifyPropertyChange(ObservableProperty.NAME, this.name, name);
        if (this.name != null)
            this.name.setParentNode(null);
        this.name = name;
        setAsParentNodeOf(name);
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        return super.remove(node);
    }

    @Override
    public String asString() {
        return "`" + name.asString() + "`";
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (node == name) {
            setName((SimpleName) replacementNode);
            return true;
        }
        return super.replace(node, replacementNode);
    }

    @Override
    public ResolvedType resolve() {
        return null;
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

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifPlaceholderType(Consumer<PlaceholderType> action) {
        action.accept(this);
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
