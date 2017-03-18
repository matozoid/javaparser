/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2017 The JavaParser Team.
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

import org.junit.Test;

import static com.github.javaparser.JavaParser.parseExpression;
import static org.assertj.core.api.Assertions.assertThat;

public class LiteralStringValueExprTest {

    @Test
    public void longLiteralsAreConverted() {
        LongLiteralExpr dec = parseExpression("9223372036854775807L");
        LongLiteralExpr posOct = parseExpression("07_7777_7777_7777_7777_7777L");
        LongLiteralExpr negOct = parseExpression("010_0000_0000_0000_0000_0000L");
        LongLiteralExpr posHex = parseExpression("0x7fff_ffff_ffff_ffffL");
        LongLiteralExpr negHex = parseExpression("0xffff_ffff_ffff_ffffL");
        LongLiteralExpr posBin = parseExpression("0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L");
        LongLiteralExpr negBin = parseExpression("0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L");

        assertThat(dec.asLong()).isEqualTo(9223372036854775807L);
        assertThat(posOct.asLong()).isEqualTo(9223372036854775807L); // 07_7777_7777_7777_7777_7777L
        assertThat(negOct.asLong()).isEqualTo(-9223372036854775808L); // 010_0000_0000_0000_0000_0000L
        assertThat(posHex.asLong()).isEqualTo(0x7fff_ffff_ffff_ffffL);
        assertThat(negHex.asLong()).isEqualTo(0xffff_ffff_ffff_ffffL);
        assertThat(posBin.asLong()).isEqualTo(0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L);
        assertThat(negBin.asLong()).isEqualTo(0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L);
    }

    @Test
    public void integerLiteralsAreConverted() {
        IntegerLiteralExpr dec = parseExpression("2147483647");
        IntegerLiteralExpr posOct = parseExpression("0177_7777_7777");
        IntegerLiteralExpr negOct = parseExpression("0377_7777_7777");
        IntegerLiteralExpr posHex = parseExpression("0x7fff_ffff");
        IntegerLiteralExpr negHex = parseExpression("0xffff_ffff");
        IntegerLiteralExpr posBin = parseExpression("0b0111_1111_1111_1111_1111_1111_1111_1111");
        IntegerLiteralExpr negBin = parseExpression("0b1000_0000_0000_0000_0000_0000_0000_0000");

        assertThat(dec.asInt()).isEqualTo(2147483647);
        assertThat(posOct.asInt()).isEqualTo(2147483647); // 0177_7777_7777
        assertThat(negOct.asInt()).isEqualTo(-1); // 0377_7777_7777
        assertThat(posHex.asInt()).isEqualTo(0x7fff_ffff);
        assertThat(negHex.asInt()).isEqualTo(0xffff_ffff);
        assertThat(posBin.asInt()).isEqualTo(0b0111_1111_1111_1111_1111_1111_1111_1111);
        assertThat(negBin.asInt()).isEqualTo(0b1000_0000_0000_0000_0000_0000_0000_0000);

        IntegerLiteralExpr integerLiteralExpr = new IntegerLiteralExpr("0B0");
        assertThat(integerLiteralExpr.asInt()).isEqualTo("0");
    }

    @Test
    public void endOfLineIsConverted() {
        Expression expr = parseExpression("'\\n'");

        assertThat(expr).isInstanceOf(CharLiteralExpr.class);
        assertThat(((CharLiteralExpr) expr).asChar()).isEqualTo('\n');
    }

    @Test
    public void simpleChar() {
        Expression expr = parseExpression("'a'");

        assertThat(expr).isInstanceOf(CharLiteralExpr.class);
        assertThat(((CharLiteralExpr) expr).asChar()).isEqualTo('a');
    }

    @Test
    public void notAChar() {
        // Invalid!
        Expression expr = parseExpression("'\n'");
    }

    @Test
    public void doubleLiteralsAreConverted() {
        DoubleLiteralExpr literalExpr = new DoubleLiteralExpr(25.0d);

        // Hm, why does it keep the .0? Should it?
        assertThat(literalExpr.getValue()).isEqualTo("25");
        assertThat(literalExpr.asDouble()).isEqualTo(25.0d);

        // A test that uses the special constructor, then the special getter to test it misses an important part: is the value correct?
    }

    @Test
    public void hexDoubleLiteralsAreConverted() {
        DoubleLiteralExpr e = parseExpression("0x2.0P2");

        assertThat(e.asDouble()).isEqualTo(0x2.0p2);
    }

}
