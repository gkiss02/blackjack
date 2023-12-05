package com.example;

import javax.swing.*;

/**
 * The StaticsTable class represents a JFrame that displays statistics in a table format.
 */
public class StaticsTable extends JFrame {
    public StaticsTable() {
        initComponents();
    }

    private void initComponents() {
        Statics statics = App.statics;
        String[][] data = {
            { "Total games played", statics.totalGames() + "" },
            { "Win", statics.getWins() + "" },
            { "Lose", statics.getLoses() + "" },
            { "Draw", statics.getTies() + "" },
            {"Coins win", statics.getCoinsWon() + ""},
            {"Coins lose", statics.getCoinsLost() + ""},
        };

        String[] columnNames = { "Name", "Value" };

        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(j);
        add(sp);
        setSize(500, 200);
        setVisible(true);
        setResizable(false);
    }
    JTable j;
}
