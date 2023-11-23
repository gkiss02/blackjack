package com.example;

public class Card {
    private int value;
    private char symbolType;
    private CardGraphic cardGraphic;
    private String name;

    public Card(int value, char symbolType, String name) {
        this.value = value;
        this.symbolType = symbolType;
        this.name = name;
        cardGraphic = new CardGraphic(this.name, this.symbolType);
    }

    public int getValue() {
        return value;
    }

    public char getSymbolType() {
        return symbolType;
    }

    public CardGraphic getCardGraphic() {
        return cardGraphic;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
