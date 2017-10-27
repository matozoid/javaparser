package com.github.javaparser.ast.stmt;

import com.github.javaparser.ast.body.BodyDeclaration;
import org.junit.Test;

import static com.github.javaparser.JavaParser.parseBodyDeclaration;

public class PlaceholderStmtTest {
    @Test
    public void test() {
        BodyDeclaration<?> bodyDeclaration = parseBodyDeclaration("int x() { int a; \\abc; print(1);}");
        System.out.println(bodyDeclaration);
    }

}