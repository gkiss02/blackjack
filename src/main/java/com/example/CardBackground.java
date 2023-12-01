package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class CardBackground extends JPanel {
	public CardBackground() {
		initComponents();
	}

	private void initComponents() {
		top = new JLabel();
		bottom = new JLabel();
		panel1 = new JPanel();
		symbol = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();

		setBorder(new LineBorder(Color.black, 1));

		setBackground(Color.white);

		setLayout(null);

		top.setText("\u2666");
		top.setForeground(Color.red);
		add(top);
		top.setBounds(new Rectangle(new Point(0, 0), top.getPreferredSize()));

		bottom.setText("\u2663");
		bottom.setForeground(Color.red);
		add(bottom);
		bottom.setBounds(new Rectangle(new Point(40, 70), bottom.getPreferredSize()));

		panel1.setBackground(Color.white);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		symbol.setForeground(Color.red);
		symbol.setText("Black");
		panel1.add(symbol);

		label1.setText("Jack");
		label1.setForeground(Color.black);
		panel1.add(label1);
		
		add(panel1);
		panel1.setBounds(10, 25, 35, 35);

		label2.setText("\u2663");
		label2.setForeground(Color.black);
		add(label2);
		label2.setBounds(new Rectangle(new Point(40, 0), label2.getPreferredSize()));

		label3.setText("\u2660");
		label3.setForeground(Color.black);
		add(label3);
		label3.setBounds(new Rectangle(new Point(0, 70), label3.getPreferredSize()));
	}

	private JLabel top;
	private JLabel bottom;
	private JPanel panel1;
	private JLabel symbol;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
}
