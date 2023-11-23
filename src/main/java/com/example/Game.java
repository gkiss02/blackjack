package com.example;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Game extends JFrame {
	private JLabel dealerLabel;
	private JLabel playerLabel;
	private JButton hintButton;
	private JButton stopButton;
	private JButton doubleButton;
	private JButton holdButton;
	private JLabel betLabel;
	private JPanel coinHolder;
	private JPanel playerScoreHolder;
	private JLabel playerScore;
	private JPanel dealerScoreHolder;
	private JLabel dealerScore;
	private JPanel playerCardHolder;

	Deck deck;

	Player player = new Player();

	public Game() {
		initComponents();
	}

	private void initComponents() {
		dealerLabel = new JLabel();
		playerLabel = new JLabel();
		hintButton = new JButton();
		stopButton = new JButton();
		doubleButton = new JButton();
		holdButton = new JButton();
		betLabel = new JLabel();
		coinHolder = new JPanel();
		playerScoreHolder = new JPanel();
		playerScore = new JLabel();
		dealerScoreHolder = new JPanel();
		dealerScore = new JLabel();
		playerCardHolder = new JPanel();

		deck = new Deck();

		setBackground(new Color(0x009900));

		setLayout(null);

		dealerLabel.setText("Dealer");
		dealerLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		add(dealerLabel);
		dealerLabel.setBounds(new Rectangle(new Point(415, 120), dealerLabel.getPreferredSize()));

		playerLabel.setText("Player");
		playerLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		add(playerLabel);
		playerLabel.setBounds(new Rectangle(new Point(420, 375), playerLabel.getPreferredSize()));

		hintButton.setText("Hint");
		add(hintButton);
		hintButton.setBounds(new Rectangle(new Point(300, 495), hintButton.getPreferredSize()));
		final Deck finalDeck = deck;
		hintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Card card = finalDeck.draw();
				player.addCard(card);
				playerScore.setText("Score:" + player.getScore());
				playerCardHolder.add(card.getCardGraphic());
				setSize(900,650);

				if (player.getScore() == -1) {
					GameoverModal gameoverModal = new GameoverModal(Game.this, "Bust");
					gameoverModal.setSize(400, 300);
					gameoverModal.setVisible(true);
					hintButton.setEnabled(false);
				}
			}
		});

		stopButton.setText("Stop");
		add(stopButton);
		stopButton.setBounds(new Rectangle(new Point(525, 495), stopButton.getPreferredSize()));

		doubleButton.setText("Double");
		add(doubleButton);
		doubleButton.setBounds(new Rectangle(new Point(450, 495), doubleButton.getPreferredSize()));

		holdButton.setText("Hold");
		add(holdButton);
		holdButton.setBounds(new Rectangle(new Point(375, 495), holdButton.getPreferredSize()));

		betLabel.setText("Bet");
		betLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		add(betLabel);
		betLabel.setBounds(new Rectangle(new Point(755, 395), betLabel.getPreferredSize()));
		
		coinHolder.setBorder(new LineBorder(Color.white, 1, true));
		coinHolder.setBackground(new Color(0x009900));
		coinHolder.setLayout(null);
		
		add(coinHolder);
		coinHolder.setBounds(730, 420, 70, 66);
		
		playerScoreHolder.setPreferredSize(new Dimension(80, 30));
		playerScoreHolder.setBackground(new Color(0x666666));
		playerScoreHolder.setLayout(null);

		playerScoreHolder.add(playerScore);
		playerScore.setText("Score: 0");
		playerScore.setBounds(new Rectangle(10,10,60,17));
		
		add(playerScoreHolder);
		playerScoreHolder.setBounds(415, 535, 70, 35);
		
		dealerScoreHolder.setMinimumSize(new Dimension(76, 27));
		dealerScoreHolder.setMaximumSize(new Dimension(76, 27));
		dealerScoreHolder.setBackground(new Color(0x666666));
		dealerScoreHolder.setLayout(null);

		dealerScore.setText("9 or 19");
		dealerScoreHolder.add(dealerScore);
		dealerScore.setBounds(new Rectangle(new Point(10, 10), dealerScore.getPreferredSize()));
		
		add(dealerScoreHolder);
		dealerScoreHolder.setBounds(415, 150, 60, 35);

		add(playerCardHolder);
		playerCardHolder.setLayout(new BoxLayout(playerCardHolder, BoxLayout.X_AXIS));
		playerCardHolder.setBounds(new Rectangle(430,400, 54, 87));
	}
}
