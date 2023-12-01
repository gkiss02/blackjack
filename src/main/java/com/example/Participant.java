package com.example;

import java.util.ArrayList;

class Participant {
    private ArrayList<Card> cards;
    private int score;

    public Participant() {
        cards = new ArrayList<Card>();
        score = 0;
    }

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

    public int getScore() {
        return score;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

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