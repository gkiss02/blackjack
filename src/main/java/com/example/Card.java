package com.example;

/**
 * Represents a playing card.
 */
public class Card {
    private int value;
    private char symbolType;
    private CardGraphic cardGraphic;
    private String name;

    /**
     * Constructs a Card object with the specified value, symbol type, and name.
     * 
     * @param value      the value of the card
     * @param symbolType the symbol type of the card
     * @param name       the name of the card
     */
    public Card(int value, char symbolType, String name) {
        this.value = value;
        this.symbolType = symbolType;
        this.name = name;
        cardGraphic = new CardGraphic(this.name, this.symbolType);
    }

    /**
     * Returns the value of the card.
     * 
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the symbol type of the card.
     * 
     * @return the symbol type of the card
     */
    public char getSymbolType() {
        return symbolType;
    }

    /**
     * Returns the card graphic associated with the card.
     * 
     * @return the card graphic associated with the card
     */
    public CardGraphic getCardGraphic() {
        return cardGraphic;
    }

    /**
     * Returns the name of the card.
     * 
     * @return the name of the card
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the card.
     * 
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
}
