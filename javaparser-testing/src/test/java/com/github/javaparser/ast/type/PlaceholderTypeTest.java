package com.github.javaparser.ast.type;

import com.github.javaparser.ast.body.MethodDeclaration;
import org.junit.Test;

import static com.github.javaparser.JavaParser.parseBodyDeclaration;
import static com.github.javaparser.utils.TestUtils.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceholderTypeTest {
    @Test
    public void test() {
        MethodDeclaration methodDeclaration = parseBodyDeclaration("int x() { `def` a; print(1);}").asMethodDeclaration();
        assertInstanceOf(PlaceholderType.class, methodDeclaration.asMethodDeclaration()
                .getBody().get()
                .getStatement(0).asExpressionStmt()
                .getExpression().asVariableDeclarationExpr()
                .getVariable(0)
                .getType()
        );
        assertEquals("def", methodDeclaration.findFirst(PlaceholderType.class).get().getPlaceholderKeyAsString());
    }

}