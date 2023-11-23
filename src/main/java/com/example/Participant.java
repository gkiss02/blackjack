package com.example;

import java.util.ArrayList;

abstract class Participant {
    private ArrayList<Card> cards;
    private int score;

    public Participant() {
        cards = new ArrayList<Card>();
        score = 0;
    }

    public void addCard(Card card) {
        if (card.getValue() == 1 && score + 11 <= 21) {
            card.setValue(11);
        }

        cards.add(card);
        score += card.getValue();

        if (score > 21) {
            score = -1;
        }
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void reset() {
        cards = new ArrayList<Card>();
        score = 0;
    }
}