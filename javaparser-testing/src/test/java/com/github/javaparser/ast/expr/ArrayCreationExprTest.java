package com.github.javaparser.ast.expr;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseStart;
import org.junit.Test;

import static com.github.javaparser.Providers.provider;

public class ArrayCreationExprTest {
    private final JavaParser parser = new JavaParser();

    @Test
    public void recover1() {
        Expression expression = parser.parse(ParseStart.EXPRESSION, provider("new String[a a a]")).getResult().get();
        System.out.println(expression);
    }

    @Test
    public void recover2() {
        Expression expression = parser.parse(ParseStart.EXPRESSION, provider("new String[(]")).getResult().get();
        System.out.println(expression);
    }
}
