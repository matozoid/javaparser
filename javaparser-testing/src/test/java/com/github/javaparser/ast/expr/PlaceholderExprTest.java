package com.github.javaparser.ast.expr;

import com.github.javaparser.ast.body.BodyDeclaration;
import org.junit.Test;

import static com.github.javaparser.JavaParser.parseBodyDeclaration;
import static com.github.javaparser.JavaParser.parseExpression;
import static org.junit.Assert.*;

public class PlaceholderExprTest {
    @Test
    public void test() {
        Expression expression = parseExpression("1+`a`+3");
        System.out.println(expression);
    }


}