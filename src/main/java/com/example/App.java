package com.example;

import javax.swing.*;

/**
 * The main class of the Blackjack application.
 */
public class App 
{
    public static Statics statics = new Statics();
    
    /**
     * The entry point of the application.
     * Initializes the necessary components and starts the game.
     * @param args The command line arguments.
     */
    public static void main( String[] args )
    {
        statics.read();
        JFrame frame = new JFrame("Black Jack");
        frame.add(new MainMenu());
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
