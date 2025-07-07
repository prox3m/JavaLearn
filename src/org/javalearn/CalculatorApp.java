package org.javalearn;

import java.util.Stack;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorApp {
    /**
     * НЕОБХОДИМЫЕ ДОРАБОТКИ
     * 
     * Calculate - обработка формулы из mathFormula
     *             проверка на верный синтаксис
     * 
     * SwitchSign - инвертирует знак числа
     * 
     * actionAdd - добавление операторов учитывая отрицательные числа
     * 
     * 
     * СДЕЛАНО
     * 
     * isOperationBefore - проверка на близость операторов (кроме скобок)
     * 
     * digitAdd - добавление чисел
     * 
     * DeleteChar - удаляет один символ (действие или цифру)
     * 
     * Results - вывод результата в mathAnswer
     * 
     * SetFrameSettings - настройки frame
     * 
     * ButtonsNumbers - добавление цифр/действий
     *                  привязка кнопок к функциям
     * 
     * ButtonsControl - добавление скобок "()"
     *                  очитска текста
     *                  изменение знака +/-
     * 
     * TextDisplay - добавление двух строк
     *               mathFormula - хранит в себе задачу
     *               mathAnswer - хранит ответ задачи
     */
    
    private final JFrame frame;
    private final JTextField mathFormula;
    private final JTextField mathAnswer;
    private final GridBagConstraints c;
    private JButton button;
    
    public CalculatorApp() {
        frame = new JFrame("Калькулятор");
        mathFormula = new JTextField();
        mathAnswer = new JTextField();
        c = new GridBagConstraints();
    }
    
    private double calculate(String formula){
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        return 0.0;
    }
    
    private boolean isOperationBefore(){
        String formula = mathFormula.getText();
        if (formula.isEmpty())
            return false;
        else {
            String operation = "" + formula.charAt(formula.length()-1);
            return !operation.equals("%") && !operation.equals("/") &&
                   !operation.equals("*") && !operation.equals("+") &&
                   !operation.equals("-");
        }
    }
    
    private void actionAdd(String action){
        String formula = mathFormula.getText();
        mathFormula.setText(formula + action);
    }
    
    private void digitAdd(String digit){
        String formula = mathFormula.getText();
        mathFormula.setText(formula + digit);
    }
    
    private void deleteChar(){
        String formula = mathFormula.getText();
        
        if (!formula.isEmpty()){
            formula = formula.substring(0, formula.length()-1);
            mathFormula.setText(formula);
        }
    }
    
    private void results(){
        String formula = mathFormula.getText();
        
        double result = calculate(formula);
        mathAnswer.setText(String.valueOf(result));
    }
    
    private void setFrameSettings(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
    }
    
    private void buttonsNumbers(){
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        
        button = new JButton("%");
        c.gridx = 0;
        c.gridy = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (isOperationBefore()){
                    actionAdd("%");
                }
            }
        });
        
        button = new JButton("/");
        c.gridx = 1;
        c.gridy = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (isOperationBefore()){
                    actionAdd("/");
                }
            }
        });
        
        button = new JButton("*");
        c.gridx = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (isOperationBefore()){
                    actionAdd("*");
                }
            }
        });
        
        button = new JButton("-");
        c.gridx = 3;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (isOperationBefore()){
                    actionAdd("-");
                }
            }
        });
        
        button = new JButton("7");
        c.gridx = 0;
        c.gridy = 3;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("7");
            }
        });
        
        button = new JButton("8");
        c.gridx = 1;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("8");
            }
        });
        
        button = new JButton("9");
        c.gridx = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("9");
            }
        });
        
        button = new JButton("4");
        c.gridx = 0;
        c.gridy = 4;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("4");
            }
        });
        
        button = new JButton("5");
        c.gridx = 1;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("5");
            }
        });
        
        button = new JButton("6");
        c.gridx = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("6");
            }
        });
        
        button = new JButton("1");
        c.gridx = 0;
        c.gridy = 5;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("1");
            }
        });
        
        button = new JButton("2");
        c.gridx = 1;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("2");
            }
        });
        
        button = new JButton("3");
        c.gridx = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("3");
            }
        });
        
        button = new JButton("0");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                digitAdd("0");
            }
        });
        
        button = new JButton(".");
        c.gridx = 2;
        c.gridwidth = 1;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String formula = mathFormula.getText();
                if (formula.length() == 0 || formula.charAt(formula.length() - 1) == '-' || formula.indexOf('.') >= 0){
                    return;
                }
                digitAdd(".");
            }
        });
        
        button = new JButton("+");
        c.gridx = 3;
        c.gridy = 3;
        c.gridheight = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (isOperationBefore()){
                    actionAdd("+");
                }
            }
        });
        
        button = new JButton("=");
        c.gridy = 5;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                results();
            }
        });

    }
    
    private void buttonsControl() {
        button = new JButton("←");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridx = 4;
        c.gridy = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                deleteChar();
            }
        });
        
        button = new JButton("CLEAR");
        c.gridx = 4;
        c.gridy = 3;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mathFormula.setText("");
                mathAnswer.setText("");
            }
        });
        
        c.gridwidth = 1;
        c.gridheight = 1;
        
        button = new JButton("(");
        c.gridy = 4;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                actionAdd("(");
            }
        });
        
        button = new JButton(")");
        c.gridy = 5;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                actionAdd(")");
            }
        });
        
        button = new JButton("+/-");
        c.gridy = 6;
        frame.add(button, c);
    }
    
    private void textDisplay(){
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        
        mathFormula.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 5;
        frame.add(mathFormula, c);
        
        mathAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
        mathAnswer.setEditable(false);
        c.gridy = 1;
        frame.add(mathAnswer, c);
    }
    
    public void calc(){
        setFrameSettings();
        
        textDisplay();
        buttonsNumbers();
        buttonsControl();
           
        frame.setVisible(true);
    }
}
