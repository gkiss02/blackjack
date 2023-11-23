package com.example;

import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Black Jack");
        frame.add(new MainMenu());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
