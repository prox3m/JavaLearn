package org.javalearn;

public class Main {
    
   public static void main(final String[] args) {
       
       final Lexer l = new Lexer("1+22+34*4.5=x");
       while (l.nextToken()){
           System.err.println(l.toString());
       }
        // final CalculatorApp g = new CalculatorApp();
        // g.calc();
    }
}
