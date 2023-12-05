package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * The CardGraphic class represents a graphical representation of a playing card.
 * It extends the JPanel class and provides methods to initialize and set up the components of the card.
 */
public class CardGraphic extends JPanel {
	public CardGraphic(String name, char symbolType) {
		initComponents(name, symbolType);
	}

	private void initComponents(String name, char symbolType) {
		top = new JLabel();
		bottom = new JLabel();
		symbol = new JLabel();

		Color color = symbolType == '♣' || symbolType == '♠' ? Color.black : Color.red;

		setBorder(new LineBorder(Color.black, 1));

		setBackground(Color.white);

		setLayout(null);

		top.setText(name);
		top.setForeground(color);
		add(top);
		top.setBounds(new Rectangle(new Point(2, 0), top.getPreferredSize()));

		bottom.setText(name);
		bottom.setForeground(color);
		add(bottom);
		bottom.setBounds(new Rectangle(new Point(40, 70), bottom.getPreferredSize()));

		symbol.setText(symbolType + "");
		symbol.setForeground(color);
		symbol.setFont(new Font("Helvetica Neue", Font.PLAIN, 36));
		add(symbol);
		symbol.setBounds(new Rectangle(new Point(10, 25), symbol.getPreferredSize()));
	}

	private JLabel top;
	private JLabel bottom;
	private JLabel symbol;
}
