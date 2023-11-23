package com.example;

import java.awt.*;
import javax.swing.*;

public class CardGraphic extends JPanel {
	public CardGraphic(String name, char symbolType) {
		initComponents(name, symbolType);
	}

	private void initComponents(String name, char symbolType) {
		top = new JLabel();
		bottom = new JLabel();
		symbol = new JLabel();

		setBackground(Color.white);

		setLayout(null);

		top.setText(name);
		top.setForeground(Color.red);
		add(top);
		top.setBounds(new Rectangle(new Point(0, 0), top.getPreferredSize()));

		bottom.setText(name);
		bottom.setForeground(symbolType == '♣' || symbolType == '♠' ? Color.black : Color.red);
		add(bottom);
		bottom.setBounds(new Rectangle(new Point(40, 70), bottom.getPreferredSize()));

		symbol.setText(symbolType + "");
		symbol.setForeground(Color.red);
		symbol.setFont(new Font("Helvetica Neue", Font.PLAIN, 36));
		add(symbol);
		symbol.setBounds(new Rectangle(new Point(10, 25), symbol.getPreferredSize()));

	}

	private JLabel top;
	private JLabel bottom;
	private JLabel symbol;
}
