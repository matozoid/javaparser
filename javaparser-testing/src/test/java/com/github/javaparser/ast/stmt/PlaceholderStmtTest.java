package com.github.javaparser.ast.stmt;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.printer.YamlPrinter;
import org.junit.Test;

import static com.github.javaparser.JavaParser.parseBodyDeclaration;
import static com.github.javaparser.utils.TestUtils.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceholderStmtTest {
    @Test
    public void test() {
        MethodDeclaration methodDeclaration = parseBodyDeclaration("int x() { int a; `abc`; print(1);}").asMethodDeclaration();
        assertInstanceOf(PlaceholderStmt.class, methodDeclaration.asMethodDeclaration().getBody().get().getStatement(1));
        assertEquals("abc", methodDeclaration.findFirst(PlaceholderStmt.class).get().getPlaceholderKeyAsString());
    }
}