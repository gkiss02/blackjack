package com.example;

public class Player extends Participant{
    private int coin;

    public Player() {
        super();
        coin = 0;
    }

    public void addCoin(int coin) {
        this.coin += coin;
    }

    public void removeCoin(int coin) {
        this.coin -= coin;
    }

    public int getCoins() {
        return coin;
    }
}
