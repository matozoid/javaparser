package com.github.javaparser.ast.expr;

import org.junit.Test;

import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.utils.TestUtils.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceholderExprTest {
    @Test
    public void test() {
        Expression expression = parseExpression("1+`a`+3");
        assertInstanceOf(PlaceholderExpr.class, expression.asBinaryExpr().getLeft().asBinaryExpr().getRight());
        assertEquals("a", expression.findFirst(PlaceholderExpr.class).get().getPlaceholderKeyAsString().get());
    }
}