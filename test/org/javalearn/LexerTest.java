package org.javalearn;

import org.junit.Test;
import org.junit.Assert;


public class LexerTest {
    
    @Test
    public void test1() {
        
        final String expr = "((2 + x) * (16 + z)) =    y";
        final int[] expectedTypes = new int[]{
            Lexer.LPARENTHESIS,
            Lexer.LPARENTHESIS,
            Lexer.INTEGER,
            Lexer.WS,
            Lexer.OPERATOR,
            Lexer.WS,
            Lexer.VARIABLE,
            Lexer.RPARENTHESIS,
            Lexer.WS,
            Lexer.OPERATOR,
            Lexer.WS,
            Lexer.LPARENTHESIS,
            Lexer.INTEGER,
            Lexer.WS,
            Lexer.OPERATOR,
            Lexer.WS,
            Lexer.VARIABLE,
            Lexer.RPARENTHESIS,
            Lexer.RPARENTHESIS,
            Lexer.WS,
            Lexer.OPERATOR,
            Lexer.WS,
            Lexer.VARIABLE,
        };
        
        final Lexer l = new Lexer(expr);
        for (int i = 0; i < expectedTypes.length; ++i) {
            Assert.assertTrue(l.nextToken());
            Assert.assertEquals(expectedTypes[i], l.getValType());
        }
        
        Assert.assertFalse(l.nextToken());
        Assert.assertFalse(l.nextToken());
        
        
        // String a1 = "1+2+3(4*4.52)=(x+2*x)";
        // String a2 = "1+2+34*4.52=(x+2x)";
    }
    
    @Test
    public void test2() {
        final String expr = " (2+x) / x = y * (12- z)   ";
        final int[] expected = new int[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 27
        };
        final Lexer l = new Lexer(expr);
        for (int i = 0; i < expected.length; i++){
            Assert.assertTrue(l.nextToken());
            Assert.assertEquals(expected[i], l.getIndex());
        }
        
        Assert.assertFalse(l.nextToken());
        Assert.assertFalse(l.nextToken());
    }
    
    @Test
    public void test3() {
        final String expr = "  12 +6 == y";
        final String[] expected = new String[] {
            "  ", "12", " ", "+", "6", " ", "==", " ", "y"
        };
        final Lexer l = new Lexer(expr);
        for (int i = 0; i < expected.length; i++){
            Assert.assertTrue(l.nextToken());
            Assert.assertEquals(expected[i], l.getStrVal());
        }
        
        Assert.assertFalse(l.nextToken());
        Assert.assertFalse(l.nextToken());
    }
}
