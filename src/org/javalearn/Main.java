package org.javalearn;

public class Main {
    
    public static void main(final String[] args) {
        
        String a1 = "1 + 5";
        final Lexer l = new Lexer(a1);
        
        System.err.println("" + mul(l));
        
        // final CalculatorApp g = new CalculatorApp();
        // g.calc();
    }
    
    public static double mul(
            final Lexer l
    ) {
        final double a = add(l);
        
        while (l.nextToken() && l.getValType() == Lexer.WS) {}
        // l.getValType() == Lexer.OPERATOR;
        // l.getStrVal().equals("*");
        
        final double b = add(l);
        return a * b;
    }
    
    public static double add(
            final Lexer l
    ) {
        final double a = term(l);
        
        while (l.nextToken() && l.getValType() == Lexer.WS) {}
        
        // if l.getValType() == Lexer.OPERATOR;
            // if l.getStrVal().equals("+") ||  l.getStrVal().equals("-");
            //    final double b = term(l);
            //    return a + b;
            
        //    return a;
        
        
        final double b = term(l);
        return a + b;
    }
    
    public static double term(
            final Lexer l
    ) {
        while (l.nextToken() && l.getValType() == Lexer.WS) {}
        
        final int type = l.getValType();
        final String val = l.getStrVal();
        switch (type) {
            case Lexer.NUMBER:
            case Lexer.INTEGER:
                return Double.valueOf(val);
            default:
                throw new UnsupportedOperationException();
       }
    }
    
    
}
