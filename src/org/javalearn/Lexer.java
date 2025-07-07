package org.javalearn;

import java.util.Arrays;
import java.util.List;

public class Lexer {
    
    private static final int ERROR = -1;
    private static final int UNDEFINED = 0;
    private static final int VARIABLE = 1;
    private static final int OPERATOR = 2;
    private static final int NUMBER = 3;
    
    private static final List<String> OPERATORS = Arrays.asList("=", "==");
    
    private String strVal;
    private double doubleVal;
    private int valType;
    private String expression;
    
    public Lexer(String src){
        this.expression = src;
    }
    
    @Override
    public String toString(){
        switch (valType) {
            case NUMBER:
                return "Num " + doubleVal;
            case OPERATOR:
                return "Opr " + strVal;
            case VARIABLE:
                return "Var " + strVal;
            default:
                throw new IllegalStateException();
        }
    }
    
    private boolean isOperation(String c){
        return c.equals("%") || c.equals("/") ||
               c.equals("*") || c.equals("-") ||
               c.equals("+");
    }
    
    private boolean isNumber(String c){
        return c.equals("0") || c.equals("1") ||
               c.equals("2") || c.equals("3") ||
               c.equals("4") || c.equals("5") ||
               c.equals("6") || c.equals("7") ||
               c.equals("8") || c.equals("9") ||
               c.equals(".");
    }
    
    public boolean nextToken(){
        if (expression.length() == 0) 
            return false;
        
        int curType = UNDEFINED;
        while (true) {
            
            // x1
            // 21
            final char c = expression.charAt(index);
            // = - + < > / * % 
            // (
            // )
            // a b c d e f
            // 1 2 3 4 5 6 7 8 9 0 .
            // WS
            // error
            if (curType == UNDEFINED) {
                if (Character.isDigit(c)) {
                    curType = NUMBER;
                } else if (Character.isWhitespace(c)) {
                    //
                } else if (isOperation(c)) {
                    strVal += c;
                } else if (...) {
                } else {
                    curType = ERROR;
                    break;
                }
            } else if (curType == VARIABLE) {
                if (Character.isDigit(c)) {
                    curType = VARIABLE;
                }
            } else if (curType == OPERATOR) {
                if (Character.isDigit(c) && strVal == "-") {
                    curType = NUMBER;
                } else if (isOperation(c)) {
                    final String op = strVal + c;
                    if (OPERATORS.contains(op)) {
                        strVal = op;
                        // ok
                    } else {
                        // break
                    }
                }
                
            }
            
        }
        
        String character = "" + expression.charAt(0);
        if (isNumber(character)){
            strVal = "";
            doubleVal = Double.valueOf(character);
            valType = NUMBER;
        } else if (isOperation(character)){
            strVal = character;
            doubleVal = 0;
            valType = OPERATOR;
        } else {
            strVal = character;
            doubleVal = 0;
            valType = VARIABLE;
        }
        expression = expression.substring(1);
        return true;
    }
}
