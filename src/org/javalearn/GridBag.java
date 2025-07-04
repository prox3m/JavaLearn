package org.javalearn;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GridBag {
    
    public static final JFrame frame = new JFrame("Калькулятор");
    public static final JTextField mathFormula = new JTextField();
    public static final JTextField mathAnswer = new JTextField();
    public static JButton button;
    public static final GridBagConstraints c = new GridBagConstraints();
    
    public static void ActionAdd(String action){
        String formula = mathFormula.getText();
        mathFormula.setText(formula + action);
    }
    public static void DigitAdd(String digit){
        String formula = mathFormula.getText();
        mathFormula.setText(formula + digit);
    }
    
    public static void SetFrameSettings(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
    }
    
    public static void ButtonsNumbers(){
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
                ActionAdd("%");
            }
        });
        
        button = new JButton("/");
        c.gridx = 1;
        c.gridy = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ActionAdd("/");
            }
        });
        
        button = new JButton("*");
        c.gridx = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ActionAdd("*");
            }
        });
        
        button = new JButton("-");
        c.gridx = 3;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ActionAdd("-");
            }
        });
        
        button = new JButton("7");
        c.gridx = 0;
        c.gridy = 3;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("7");
            }
        });
        
        button = new JButton("8");
        c.gridx = 1;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("8");
            }
        });
        
        button = new JButton("9");
        c.gridx = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("9");
            }
        });
        
        button = new JButton("4");
        c.gridx = 0;
        c.gridy = 4;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("4");
            }
        });
        
        button = new JButton("5");
        c.gridx = 1;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("5");
            }
        });
        
        button = new JButton("6");
        c.gridx = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("6");
            }
        });
        
        button = new JButton("1");
        c.gridx = 0;
        c.gridy = 5;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("1");
            }
        });
        
        button = new JButton("2");
        c.gridx = 1;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("2");
            }
        });
        
        button = new JButton("3");
        c.gridx = 2;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd("3");
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
                DigitAdd("0");
            }
        });
        
        button = new JButton(",");
        c.gridx = 2;
        c.gridwidth = 1;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DigitAdd(".");
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
                ActionAdd("+");
            }
        });
        
        button = new JButton("=");
        c.gridy = 5;
        frame.add(button, c);

    }
    
    public static void ButtonsControl(){
        button = new JButton("CLEAR");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridy = 2;
        c.gridheight = 2;
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
                ActionAdd("(");
            }
        });
        
        button = new JButton(")");
        c.gridy = 5;
        frame.add(button, c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ActionAdd(")");
            }
        });
        
        button = new JButton("+/-");
        c.gridy = 6;
        frame.add(button, c);
    }
    
    public static void TextDisplay(){
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
    
    public static void CALC(){
        SetFrameSettings();
        
        TextDisplay();
        ButtonsNumbers();
        ButtonsControl();
           
        frame.setVisible(true);
    }
}
