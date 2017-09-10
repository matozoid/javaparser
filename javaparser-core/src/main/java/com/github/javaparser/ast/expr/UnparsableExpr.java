package com.github.javaparser.ast.expr;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.UnparsableExprMetaModel;

import javax.annotation.Generated;

import static com.github.javaparser.ast.Node.Parsedness.UNPARSABLE;

/**
 * An expression that had parse errors.
 * Nothing is known about it except the tokens it covers.
 */
public final class UnparsableExpr extends Expression {

    @AllFieldsConstructor
    public UnparsableExpr() {
        this(null);
    }

    /**This constructor is used by the parser and is considered private.*/
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public UnparsableExpr(TokenRange tokenRange) {
        super(tokenRange);
        customInitialization();
    }

    @Override
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
        return v.visit(this, arg);
    }

    @Override
    public <A> void accept(final VoidVisitor<A> v, final A arg) {
        v.visit(this, arg);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        return super.remove(node);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public UnparsableExpr clone() {
        return (UnparsableExpr) accept(new CloneVisitor(), null);
    }

    @Override
    public Parsedness getParsed() {
        return UNPARSABLE;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public UnparsableExprMetaModel getMetaModel() {
        return JavaParserMetaModel.unparsableExprMetaModel;
    }
}
