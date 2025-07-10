package org.javalearn;

import java.util.Arrays;
import java.util.List;

public class Lexer {
    
    public static final int ERROR = -1;
    public static final int UNDEFINED = 0;
    public static final int VARIABLE = 1;
    public static final int OPERATOR = 2;
    public static final int INTEGER = 3;
    public static final int NUMBER = 4;
    public static final int LPARENTHESIS = 5;
    public static final int RPARENTHESIS = 6;
    public static final int WS = 7;
    
    private static final char LEFTPARENTHESIS = '(';
    private static final char RIGHTPARENTHESIS = ')';
    
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
            case ERROR:
                return "Err " + strVal + " " + errVal;
            case VARIABLE:
                return "Var " + strVal;
            case OPERATOR:
                return "Opr " + strVal;
            case INTEGER:
                return "Int " + strVal;
            case NUMBER:
                return "Num " + strVal;
            case LPARENTHESIS:
                return "LPa " + strVal;
            case RPARENTHESIS:
                return "RPa " + strVal;
            case WS:
                return "WS '" + strVal + "'";
            
            default:
                throw new IllegalStateException();
        }
    }
    
    private boolean isOperation(char c) {
        return c == '%' || c == '/' || c == '*' ||
                c == '-' || c == '+' || c == '=';
    }

    public int getValType() {
        return valType;
    }

    public String getStrVal() {
        return strVal;
    }

    public static int getIndex() {
        return index;
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
            
            if (curType == UNDEFINED) {
                if (Character.isDigit(c)) {
                    curType = INTEGER;
                    strVal += c;
                } else if (Character.isWhitespace(c)) {
                    curType = WS;
                    strVal += c;
                } else if (isOperation(c)) {
                    curType = OPERATOR;
                    strVal += c;
                } else if (Character.isAlphabetic(c)) {
                    curType = VARIABLE;
                    strVal += c;
                } else if (c == LEFTPARENTHESIS) {
                    curType = LPARENTHESIS;
                    strVal += c;
                } else if (c == RIGHTPARENTHESIS) {
                    curType = RPARENTHESIS;
                    strVal += c;
                } else {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use extra symbols in formula.";
                }
            } else if (curType == INTEGER) {
                if (Character.isDigit(c)) {
                    strVal += c;
                } else if (Character.isWhitespace(c)) {
                    break;
                } else if (isOperation(c)) {
                    break;
                } else if (Character.isAlphabetic(c) || c == LEFTPARENTHESIS) {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use hiden multyplication";
                } else if (c == '.') {
                    strVal += c;
                    curType = NUMBER;
                } else if (c == RIGHTPARENTHESIS) {
                    break;
                } else {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use extra symbols in numbers";
                }
            } else if (curType == NUMBER) {
                if (Character.isDigit(c)) {
                    strVal += c;
                } else if (Character.isWhitespace(c)) {
                    break;
                } else if (isOperation(c)) {
                    break;
                } else if (Character.isAlphabetic(c) || c == LEFTPARENTHESIS) {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use hiden multyplication";
                } else if (c == '.') {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbidden to use second delimeter in number.";
                } else if (c == RIGHTPARENTHESIS) {
                    break;
                } else {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use extra symbols in numbers";
                }
            } else if (curType == VARIABLE) {
                if (Character.isDigit(c)) {
                    curType = VARIABLE;
                    strVal += c;
                } else if (Character.isWhitespace(c)) {
                    break;
                } else if (isOperation(c)) {
                    break;
                } else if (Character.isAlphabetic(c)) {
                    strVal += c;
                } else if (c == LEFTPARENTHESIS) {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use hiden multyplication";
                } else if (c == RIGHTPARENTHESIS) {
                    break;
                } else {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use extra symbols and delimeter after variables";
                }
            } else if (curType == OPERATOR) {
                if (Character.isDigit(c) && strVal == "-") {
                    curType = NUMBER;
                } else if (Character.isDigit(c)) {
                    break;
                } else if (Character.isWhitespace(c)) {
                    break;
                } else if (Character.isAlphabetic(c)) {
                    break;
                } else if (isOperation(c)) {
                    final String op = strVal + c;
                    if (OPERATORS.contains(op)) {
                        strVal = op;
                    } else {
                        break;
                    }
                } else if (c == LEFTPARENTHESIS) {
                    break;
                } else if (c == RIGHTPARENTHESIS) {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use closing parenthesis after operator";
                } else {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use extra symbols and delimeter after operator";
                }
            } else if (curType == LPARENTHESIS){
                if (Character.isDigit(c)) {
                    break;
                } else if (Character.isWhitespace(c)) {
                    break;
                } else if (Character.isAlphabetic(c)) {
                    break;
                } else if (isOperation(c)) {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use operators straight after open parenthesis";
                } else if (c == RIGHTPARENTHESIS) {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use empty parentheses.";
                } else if (c == LEFTPARENTHESIS) {
                    break;
                } else {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use extra symbols and delimeter after open parenthesis";
                }
            } else if (curType == RPARENTHESIS) {
                if (Character.isDigit(c) || Character.isAlphabetic(c) || c == LEFTPARENTHESIS) {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use hiden multyplication";
                } else if (Character.isWhitespace(c)) {
                    break;
                } else if (isOperation(c)) {
                    break;
                } else if (c == RIGHTPARENTHESIS) {
                    break;
                } else {
                    curType = ERROR;
                    errVal = "It is forbiden to use extra symbols and delimeter after close parenthesis";
                }
            } else if (curType == WS) {
                if (Character.isDigit(c)) {
                    break;
                } else if (Character.isWhitespace(c)) {
                    strVal += c;
                } else if (Character.isAlphabetic(c)) {
                    break;
                } else if (isOperation(c)) {
                    break;
                } else if (c == LEFTPARENTHESIS) {
                    break;
                } else if (c == RIGHTPARENTHESIS) {
                    break;
                } else {
                    curType = ERROR;
                    strVal += c;
                    errVal = "It is forbiden to use extra symbols and delimeter on empty space";
                }
            }
            valType = curType;
            index++;
        }
        return true;
    }
}
