package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.json.*;

/**
 * The Statics class represents the statistics of a player in a game.
 * It stores information such as the number of coins, last login date, number of continuous plays,
 * number of wins, ties, loses, coins won, and coins lost.
 * The class provides methods to read and write the statistics from/to a JSON file,
 * as well as methods to retrieve and update the statistics.
 */
public class Statics {
    private int coins;
    private LocalDate lastLogin;
    private int continuousPlays;
    private int wins;
    private int ties;
    private int loses;
    private int coinsWon;
    private int coinsLost;

    /**
     * Reads the statics data from a JSON file and assigns the values to the corresponding variables.
     * The JSON file must be named "statics.json" and located in the current directory.
     * If the file is not found, a "File not found" message is printed to the console.
     */
    public void read() {
        try {
            JsonReader reader = Json.createReader(new FileInputStream("statics.json"));
            JsonObject statics = reader.readObject();
            reader.close();

            coins = Integer.parseInt(statics.get("coins").toString());
            lastLogin = LocalDate.parse(statics.get("lastLogin").toString().substring(1, 11));
            continuousPlays = Integer.parseInt(statics.get("continuousPlays").toString());
            wins = Integer.parseInt(statics.get("wins").toString());
            ties = Integer.parseInt(statics.get("ties").toString());
            loses = Integer.parseInt(statics.get("loses").toString());
            coinsWon = Integer.parseInt(statics.get("coinsWon").toString());
            coinsLost = Integer.parseInt(statics.get("coinsLost").toString());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Returns the number of coins.
     *
     * @return the number of coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Returns the last login date.
     *
     * @return the last login date
     */
    public LocalDate getLastLogin() {
        return lastLogin;
    }

    /**
     * Returns the number of continuous plays.
     *
     * @return the number of continuous plays
     */
    public int getContinuousPlays() {
        return continuousPlays;
    }

    /**
     * Returns the number of wins.
     *
     * @return the number of wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Returns the number of ties in the game.
     *
     * @return the number of ties
     */
    public int getTies() {
        return ties;
    }

    /**
     * Returns the number of loses.
     *
     * @return the number of loses
     */
    public int getLoses() {
        return loses;
    }

    /**
     * Returns the number of coins won.
     *
     * @return The number of coins won.
     */
    public int getCoinsWon() {
        return coinsWon;
    }

    /**
     * Returns the number of coins lost.
     *
     * @return the number of coins lost
     */
    public int getCoinsLost() {
        return coinsLost;
    }
    
    /**
     * Increases the number of wins by one.
     */
    public void increaseWins() {
        this.wins++;
    }

    /**
     * Increases the number of ties in the game.
     */
    public void increaseTies() {
        this.ties++;
    }

    /**
     * Increases the number of losses by 1.
     */
    public void increaseLoses() {
        this.loses++;
    }

    /**
     * Sets the number of coins won.
     * 
     * @param coinsWon the number of coins won to be added
     */
    public void setCoinsWon(int coinsWon) {
        this.coinsWon += coinsWon;
    }

    /**
     * Sets the number of coins lost.
     *
     * @param coinsLost the number of coins lost to be added
     */
    public void setCoinsLost(int coinsLost) {
        this.coinsLost += coinsLost;
    }

    /**
     * Sets the number of continuous plays.
     *
     * @param continuousPlays the number of continuous plays to set
     */
    public void setContinuousPlays(int continuousPlays) {
        this.continuousPlays = continuousPlays;
    }

    /**
     * Increases the count of continuous plays.
     */
    public void increaseContinuousPlays() {
        this.continuousPlays++;
    }

    /**
     * Sets the number of coins.
     *
     * @param coins the new number of coins
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * Calculates the total number of games played.
     *
     * @return The total number of games played.
     */
    public int totalGames() {
        return wins + ties + loses;
    }

    /**
     * Writes the statistics data to a JSON file.
     */
    public void write() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("coins", coins);
            builder.add("lastLogin", LocalDateTime.now().format(dateFormat).toString());
            builder.add("continuousPlays", continuousPlays);
            builder.add("wins", wins);
            builder.add("ties", ties);
            builder.add("loses", loses);
            builder.add("coinsWon", coinsWon);
            builder.add("coinsLost", coinsLost);

            JsonObject statics = builder.build();

            JsonWriter writer = Json.createWriter(new FileOutputStream("statics.json"));
            writer.writeObject(statics);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
