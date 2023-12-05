package com.example;

/**
 * Represents a player in the game.
 * Inherits from the Participant class.
 */
public class Player extends Participant{
    private int coin;

    /**
     * Constructs a new Player object with default values.
     * Initializes the coin count to 0.
     */
    public Player() {
        super();
        coin = 0;
    }

    /**
     * Adds the specified amount of coins to the player's total.
     * @param coin the amount of coins to add
     */
    public void addCoin(int coin) {
        this.coin += coin;
    }

    /**
     * Removes the specified amount of coins from the player's total.
     * @param coin the amount of coins to remove
     */
    public void removeCoin(int coin) {
        this.coin -= coin;
    }

    /**
     * Returns the current number of coins the player has.
     * @return the number of coins
     */
    public int getCoins() {
        return coin;
    }
}
