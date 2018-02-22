package com.github.javaparser.symbolsolver;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseStart;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import org.junit.Test;

import static com.github.javaparser.Providers.provider;

public class Issue1436 {
    @Test
    public void test() {
        JavaParser javaParser = new JavaParser(new ParserConfiguration().setSymbolResolver(new JavaSymbolSolver(new ReflectionTypeSolver())));

        CompilationUnit cu = javaParser.parse(ParseStart.COMPILATION_UNIT, provider("        abstract class TypeIfc {\n" +
                "        }\n" +
                "        class TypeA {\n" +
                "            void doSomething(TypeIfc typeIfc) {\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        class B { void x() {TypeA obj = new TypeA();\n" +
                "        obj.doSomething(new TypeIfc() {\n" +
                "        });}}\n" +
                "\n")).getResult().get();

        cu.findAll(ObjectCreationExpr.class).forEach(Expression::calculateResolvedType);
    }
}
