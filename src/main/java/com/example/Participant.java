package com.example;

import java.util.ArrayList;

/**
 * Represents a participant in a blackjack game.
 */
class Participant {
    private ArrayList<Card> cards;
    private int score;

    /**
     * Constructs a new Participant object.
     * Initializes the participant's cards and score.
     */
    public Participant() {
        cards = new ArrayList<Card>();
        score = 0;
    }

    /**
     * Adds a card to the participant's hand.
     * Updates the score based on the card's value.
     * Adjusts the value of Ace cards if necessary.
     * Recalculates the total score.
     * 
     * @param card The card to be added.
     */
    public void addCard(Card card) {
        cards.add(card);
        score += card.getValue();
        
        for (Card c : cards) {
            if (c.getName().equals("A") && score + 11 <= 21) {
                c.setValue(11);
            } else if (c.getName().equals("A") && score + 11 > 21) {
                c.setValue(1);
            }
        }

        score = 0;

        for (Card c : cards) {
            score += c.getValue();
        }
    }

    /**
     * Returns the current score of the participant.
     * 
     * @return The participant's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns the cards in the participant's hand.
     * 
     * @return The participant's cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Checks if the participant has a soft hand.
     * A soft hand is defined as having a score of 17 and containing an Ace card.
     * 
     * @return true if the participant has a soft hand, false otherwise.
     */
    public boolean isSoft() {
        boolean containsA = false;
        for (Card c : cards) {
            if (c.getName().equals("A")) {
                containsA = true;
            }
        }
        return score == 17 && containsA;
    }
}