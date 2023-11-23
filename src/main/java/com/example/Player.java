package com.example;

public class Player extends Participant{
    private int coin;

    public Player() {
        super();
        coin = 100;
    }

    public void addCoin(int coin) {
        this.coin += coin;
    }

    public void removeCoin(int coin) {
        this.coin -= coin;
    }

    public int getCoin() {
        return coin;
    }
}
