package com.example;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * The Game class represents a game of Blackjack.
 * It extends the JFrame class and contains various components and logic for the game.
 */
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
	private JPanel coinTextHolder;
	private JLabel coinSymbol;
	private JLabel label2;
	private JPanel dealerCardHolder;
	private JPanel resultContainer;
	private JLabel resultText;
	private JSeparator resultSeparator;
	private JButton newGameButton;

	private Player player;
	private Deck deck = new Deck();
	private Participant dealer = new Participant();

	boolean low = false;
	boolean high = false;
	boolean isDecided = false;

	
	public Game(Player player) {
		this.player = player;
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
		dealerCardHolder = new JPanel();
		coinTextHolder = new JPanel();
		coinSymbol = new JLabel();
		label2 = new JLabel();
		resultContainer = new JPanel();
		resultText = new JLabel();
		newGameButton = new JButton();
		resultSeparator = new JSeparator();

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
		hintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (player.getScore() <= 11) {
					low = true;
				} else if (player.getScore() >= 17 && !isDecided) {
					high = true;
				} else {
					low = false;
					high = false;
				}

				if (high) {
					Modal highModal = new Modal(null, "Your score is over 17", "Are you sure you want to draw a card?");
					highModal.setSize(new Dimension(400, 300));
					highModal.setVisible(true);
					high = false;
					isDecided = true;
				} else {
					playerDrawCard();
				}
			}
		});

		holdButton.setText("Hold");
		add(holdButton);
		holdButton.setBounds(new Rectangle(new Point(375, 495), holdButton.getPreferredSize()));
		holdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (low) {
					Modal lowModal = new Modal(null, "Your score is under 11", "Are you sure you want to hold?");
					lowModal.setSize(new Dimension(400, 300));
					lowModal.setVisible(true);
					low = false;
				} else {
					disableButtons();
					dealerDrawCard();
				}
			}
		});
		

		stopButton.setText("Stop");
		add(stopButton);
		stopButton.setBounds(new Rectangle(new Point(525, 495), stopButton.getPreferredSize()));
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				disableButtons();
				App.statics.setCoins(App.statics.getCoins() + player.getCoins() / 2);
				resultText.setText("Stopped!");
				resultContainer.setVisible(true);
			}
		});

		doubleButton.setText("Double");
		add(doubleButton);
		doubleButton.setBounds(new Rectangle(new Point(450, 495), doubleButton.getPreferredSize()));
		doubleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				App.statics.setCoins(App.statics.getCoins() - player.getCoins());
				player.addCoin(player.getCoins());
				label2.setText(player.getCoins() + "");
				disableButtons();
				playerDrawCard();
				dealerDrawCard();
			}
		});

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
		
		dealerScoreHolder.setPreferredSize(new Dimension(80, 30));
		dealerScoreHolder.setBackground(new Color(0x666666));
		dealerScoreHolder.setLayout(null);

		dealerScore.setText("Score: 0");
		dealerScoreHolder.add(dealerScore);
		dealerScore.setBounds(10, 10, 60,17);
		
		add(dealerScoreHolder);
		dealerScoreHolder.setBounds(415, 150, 70, 35);

		add(dealerCardHolder);
		dealerCardHolder.setLayout(new BoxLayout(dealerCardHolder, BoxLayout.X_AXIS));
		dealerGetCard();
		dealerCardHolder.add(new CardBackground());
		dealerCardHolder.setBounds(new Rectangle((450 - 54),15, 54 * 2, 87));

		add(playerCardHolder);
		playerCardHolder.setLayout(new BoxLayout(playerCardHolder, BoxLayout.X_AXIS));

		coinTextHolder.setBackground(new Color(0x009900));
		coinTextHolder.setLayout(new BoxLayout(coinTextHolder, BoxLayout.X_AXIS));

		coinSymbol.setText("\u25cf");
		coinSymbol.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
		coinSymbol.setForeground(Color.yellow);
		coinTextHolder.add(coinSymbol);

		label2.setText(player.getCoins() + "");
		coinTextHolder.add(label2);

		coinHolder.add(coinTextHolder);
		coinTextHolder.setBounds(10, 20, 50, 29);

		resultContainer.setLayout(new BoxLayout(resultContainer, BoxLayout.Y_AXIS));

		resultText.setText("You win!");
		resultText.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
		resultContainer.add(resultText);

		resultSeparator.setPreferredSize(new Dimension(0, 7));
		resultContainer.add(resultSeparator);

		newGameButton.setText("New Game");
		resultContainer.add(newGameButton);
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AmountSelector amuntSelector = new AmountSelector(null);
				amuntSelector.setSize(new Dimension(400, 300));
				amuntSelector.setVisible(true);
				dispose();
			}
		});

		resultContainer.setVisible(false);
	
		add(resultContainer);
		resultContainer.setBounds(new Rectangle(new Point(395, 220), resultContainer.getPreferredSize()));

		setResizable(false);
	}

	private void disableButtons() {
		hintButton.setEnabled(false);
		stopButton.setEnabled(false);
		doubleButton.setEnabled(false);
		holdButton.setEnabled(false);
	}

	/**
	 * Draws a card from the deck and adds it to the player's hand.
	 * Updates the player's score, displays the card graphic, and adjusts the size of the card holder.
	 * If the player has two cards and a score of 21, it updates the player's coins, displays "Blackjack!",
	 * shows the result container, disables buttons, increases wins, sets coins won, and writes the statistics.
	 * If the player's score exceeds 21, it displays "Bust!", shows the result container, disables buttons,
	 * increases losses, sets coins lost, and writes the statistics.
	 */
	private void playerDrawCard() {
		Card card = deck.draw();
		player.addCard(card);
		playerScore.setText("Score:" + player.getScore());
		playerCardHolder.add(card.getCardGraphic());
		playerCardHolder.setBounds(new Rectangle((450 - 54 * player.getCards().size() / 2),400, 54 * player.getCards().size(), 87));
		setSize(900,650);

		if (player.getCards().size() == 2 && player.getScore() == 21) {
			App.statics.setCoins(App.statics.getCoins() + player.getCoins() * 5 / 2);
			resultText.setText("Blackjack!");
			resultContainer.setVisible(true);
			disableButtons();
			App.statics.increaseWins();
			App.statics.setCoinsWon(player.getCoins() * 5 / 2);
			App.statics.write();
		}

		if (player.getScore() > 21) {
			resultText.setText("Bust!");
			resultContainer.setVisible(true);
			disableButtons();
			App.statics.increaseLoses();
			App.statics.setCoinsLost(player.getCoins());
			App.statics.write();
		}
	}

	/**
	 * This method is responsible for the dealer drawing a card in the game.
	 * It updates the dealer's score, and determines the outcome of the game based on the dealer's score and the player's score.
	 * If the dealer's score is less than or equal to 16 or the dealer has a soft hand,
	 * and the dealer's score is less than the player's score and less than 21,
	 * the dealer continues to draw cards until one of the conditions is no longer met.
	 * Once the game outcome is determined, the appropriate result is displayed,
	 * and the game statistics and coin balance are updated accordingly.
	 */
	private void dealerDrawCard() {
		dealerCardHolder.remove(1);
		Timer timer = new Timer(2000, new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				if ((dealer.getScore() <= 16 || dealer.isSoft()) && dealer.getScore() < player.getScore() && dealer.getScore() < 21) {
					dealerGetCard();
					dealerCardHolder.setBounds(new Rectangle((450 - 54 * dealer.getCards().size() / 2),15, 54 * dealer.getCards().size(), 87));
					setSize(900, 650);
				} else {
					((Timer) e.getSource()).stop();
					if (dealer.getScore() > player.getScore() && dealer.getScore() <= 21) {
						resultText.setText("You lose!");
						resultContainer.setVisible(true);
						App.statics.increaseLoses();
						App.statics.setCoinsLost(player.getCoins());
						App.statics.write();
					} else if (dealer.getScore() == player.getScore()) {
						App.statics.setCoins(App.statics.getCoins() + player.getCoins());
						resultText.setText("Tie!");
						resultContainer.setVisible(true);
						App.statics.increaseTies();
						App.statics.write();
					} else {
						App.statics.setCoins(App.statics.getCoins() + player.getCoins() * 2);
						resultText.setText("You win!");
						resultContainer.setVisible(true);
						App.statics.increaseWins();
						App.statics.setCoinsWon(player.getCoins() * 2);
						App.statics.write();
					}
				}
			}
		});
		timer.start();
	}

	/**
	 * Deals a card to the dealer, updates the dealer's score, and adds the card to the dealer's card holder.
	 */
	private void dealerGetCard () {
		Card card = deck.draw();
		dealer.addCard(card);
		dealerScore.setText("Score:" + dealer.getScore());
		dealerCardHolder.add(card.getCardGraphic());
	}
}