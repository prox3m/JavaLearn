package org.javalearn;

import java.awt.*;
import javax.swing.*;

public class GridBag {
    public static void GUI(){
        
        final JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        JButton button;
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        button = new JButton("Button 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        frame.add(button, gbc);
        
        button = new JButton("Button 2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        frame.add(button, gbc);
        
        button = new JButton("Button 3");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        frame.add(button, gbc);
        
        button = new JButton("Button 4");
        gbc.ipady = 40;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        frame.add(button, gbc);
        
        button = new JButton("Button 5");
        gbc.ipady = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(button, gbc);
        
        frame.setVisible(true);
    }

    public static void CALC(){
        final JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
        
        JButton button;
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        button = new JButton("%");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        frame.add(button, c);
        
        button = new JButton("/");
        c.gridx = 1;
        frame.add(button, c);
        
        button = new JButton("*");
        c.gridx = 2;
        frame.add(button, c);
        
        button = new JButton("-");
        c.gridx = 3;
        frame.add(button, c);
        
        button = new JButton("7");
        c.gridx = 0;
        c.gridy = 1;
        frame.add(button, c);
        
        button = new JButton("8");
        c.gridx = 1;
        frame.add(button, c);
        
        button = new JButton("9");
        c.gridx = 2;
        frame.add(button, c);
        
        button = new JButton("4");
        c.gridx = 0;
        c.gridy = 2;
        frame.add(button, c);
        
        button = new JButton("5");
        c.gridx = 1;
        frame.add(button, c);
        
        button = new JButton("6");
        c.gridx = 2;
        frame.add(button, c);
        
        button = new JButton("1");
        c.gridx = 0;
        c.gridy = 3;
        frame.add(button, c);
        
        button = new JButton("2");
        c.gridx = 1;
        frame.add(button, c);
        
        button = new JButton("3");
        c.gridx = 2;
        frame.add(button, c);
        
        button = new JButton("0");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        frame.add(button, c);
        
        button = new JButton(",");
        c.gridx = 2;
        c.gridwidth = 1;
        frame.add(button, c);
        
        button = new JButton("+");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 1;
        c.gridheight = 2;
        frame.add(button, c);
        
        button = new JButton("=");
        c.gridy = 3;
        frame.add(button, c);
        
        frame.setVisible(true);
    }
}
