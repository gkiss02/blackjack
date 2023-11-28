package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JPanel {
	public MainMenu() {
		initComponents();
	}

	private void initComponents() {
		playButton = new JButton();
		staticsButton = new JButton();
		exitButton = new JButton();
		coinCounterLabel = new JLabel();
		madeByLabel = new JLabel();

		setLayout(null);

		setPreferredSize(new Dimension(400, 250));

		playButton.setText("Play");
		add(playButton);
		playButton.setBounds(new Rectangle(new Point(165, 65), playButton.getPreferredSize()));
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AmountSelector amuntSelector = new AmountSelector(null);
				amuntSelector.setSize(new Dimension(400, 300));
				amuntSelector.setVisible(true);
			}
		});

		staticsButton.setText("Statics");
		add(staticsButton);
		staticsButton.setBounds(165, 100, 76, 27);

		exitButton.setText("Exit");
		add(exitButton);
		exitButton.setBounds(new Rectangle(new Point(165, 135), exitButton.getPreferredSize()));

		coinCounterLabel.setText("Coins: " + App.statics.getCoins());
		add(coinCounterLabel);
		coinCounterLabel.setBounds(new Rectangle(new Point(325, 10), coinCounterLabel.getPreferredSize()));

		madeByLabel.setText("Gabor Kiss - JK7FAO");
		madeByLabel.setFont(madeByLabel.getFont().deriveFont(10f));
		add(madeByLabel);
		madeByLabel.setBounds(new Rectangle(new Point(10, 215), madeByLabel.getPreferredSize()));
	}

	private JButton playButton;
	private JButton staticsButton;
	private JButton exitButton;
	private JLabel coinCounterLabel;
	private JLabel madeByLabel;
}
