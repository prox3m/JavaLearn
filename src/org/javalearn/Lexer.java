package org.javalearn;

import java.util.Arrays;
import java.util.List;

public class Lexer {
    
    private static final int ERROR = -1;
    private static final int UNDEFINED = 0;
    private static final int VARIABLE = 1;
    private static final int OPERATOR = 2;
    private static final int INTEGER = 3;
    private static final int NUMBER = 4;
    private static final int LPARENTHESIS = 5;
    private static final int RPARENTHESIS = 6;
    private static final int WS = 7;
    
    private static final List<String> OPERATORS = Arrays.asList(
            "-", "+", "/", "*", "%",
            "<", ">","==", "<=", ">=", 
            "=", "-=", "+=", "/=", "*=", "%=",
            "--", "++"
    );
    
    private final String expression;
    
    private String strVal;
    private String errVal;
    private int valType;
    private static int index;
    
    public Lexer(String src) {
        this.expression = src;
        strVal = "";
        errVal = "";
        index = 0;
    }
    
    @Override
    public String toString() {
        switch (valType) {
            case INTEGER:
                return "Int " + strVal;
            case NUMBER:
                return "Num " + strVal;
            case OPERATOR:
                return "Opr " + strVal;
            case VARIABLE:
                return "Var " + strVal;
            case ERROR:
                return "Err " + strVal + " " + errVal;
            default:
                throw new IllegalStateException();
        }
    }
    
    private boolean isOperation(char c) {
        return c == '%' || c == '/' || c == '*' ||
                c == '-' || c == '+' || c == '=';
    }
    
    public boolean nextToken() {
        if (expression.length() == 0) {
            return false;
        }
        
        strVal = "";
        
        int curType = UNDEFINED;        
        if (index >= expression.length()) {
            return false;
        }
        
        while (index < expression.length()) {
            
            if (curType == ERROR) {
                break;
            }
            
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
                    curType = INTEGER;
                    strVal += c;
                } else if (Character.isWhitespace(c)) {
                    //skip
                } else if (isOperation(c)) {
                    curType = OPERATOR;
                    strVal += c;
                } else if (Character.isAlphabetic(c)) {
                    curType = VARIABLE;
                    strVal += c;
                } else {
                    curType = ERROR;
                    errVal = "It is forbiden to use extra symbols in formula.";
                    
                    break;
                }
            } else if (curType == INTEGER) {
                if (Character.isDigit(c)) {
                    strVal += c;
                } else if (Character.isWhitespace(c)) {
                    //skip
                } else if (isOperation(c)) {
                    break;
                } else if (Character.isAlphabetic(c)) {
                    break;
                } else if (c == '.') {
                    strVal += c;
                    curType = NUMBER;
                }
            } else if (curType == NUMBER) {
                if (Character.isDigit(c)) {
                    strVal += c;
                } else if (Character.isWhitespace(c)) {
                    //skip
                } else if (isOperation(c)) {
                    break;
                } else if (Character.isAlphabetic(c)) {
                    break;
                } else if (c == '.') {
                    curType = ERROR;
                    errVal = "It is forbidden to use second delimeter in number.";
                }
            } else if (curType == VARIABLE) {
                if (Character.isDigit(c)) {
                    curType = VARIABLE;
                    strVal += c;
                } else if (Character.isWhitespace(c)) {
                    //skip
                } else if (isOperation(c)) {
                    break;
                } else if (Character.isAlphabetic(c)) {
                    strVal += c;
                }
            } else if (curType == OPERATOR) {
                if (Character.isDigit(c) && strVal == "-") {
                    curType = NUMBER;
                } else if (Character.isDigit(c)) {
                    
                    break;
                } else if (Character.isWhitespace(c)) {
                    //skip
                } else if (Character.isAlphabetic(c)) {
                    
                    break;
                } else if (isOperation(c)) {
                    final String op = strVal + c;
                    if (OPERATORS.contains(op)) {
                        strVal = op;
                    } else {
                        
                        break;
                    }
                }
                
            }
            valType = curType;
            index++;
        }
        return true;
    }
}
