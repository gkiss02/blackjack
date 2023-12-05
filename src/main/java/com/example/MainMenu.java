package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;

/**
 * The MainMenu class represents the main menu panel of the Blackjack game.
 * It contains buttons for playing the game, viewing statistics, and exiting the game.
 * The panel also displays the player's coin count and the creator's information.
 */
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

		if (App.statics.getLastLogin().equals(LocalDate.parse("2019-01-01"))) {
			App.statics.setCoins(1000);
			String text1 = "Welcome to the world of Black Jack!";
			String text2 = "Here is your 1000 coins as a bonus";
			Modal loginModal = new Modal(null, text1, text2);
			loginModal.setSize(new Dimension(400, 300));
			loginModal.setVisible(true);
		} 

		if (App.statics.getLastLogin().plusDays(1).equals(LocalDate.now())) {
			int bonus = 100 + 25 * App.statics.getContinuousPlays();
			App.statics.setCoins(App.statics.getCoins() + bonus);
			String text1 = "Thank you for coming back " + App.statics.getContinuousPlays() + " days in a row!";
			String text2 = "Here is your " + bonus + " coins as a bonus";
			Modal loginModal = new Modal(null, text1, text2);
			loginModal.setSize(new Dimension(400, 300));
			loginModal.setVisible(true);
		} else {
			App.statics.setContinuousPlays(0);
		}

		App.statics.increaseContinuousPlays();
		App.statics.write();

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
		staticsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StaticsTable staticsTable = new StaticsTable();
				staticsTable.setSize(new Dimension(500, 200));
				staticsTable.setVisible(true);
			}
		});

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
