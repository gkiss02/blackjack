package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.json.*;

public class Statics {
    private int coins;
    private LocalDate lastLogin;
    private int continuousPlays;
    private int wins;
    private int ties;
    private int loses;
    private int coinsWon;
    private int coinsLost;

    public Statics() {
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

    public int getCoins() {
        return coins;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public int getContinuousPlays() {
        return continuousPlays;
    }

    public int getWins() {
        return wins;
    }

    public int getTies() {
        return ties;
    }

    public int getLoses() {
        return loses;
    }

    public int getCoinsWon() {
        return coinsWon;
    }

    public int getCoinsLost() {
        return coinsLost;
    }

    public void increaseWins() {
        this.wins++;
        write();
    }

    public void increaseTies() {
        this.ties++;
        write();
    }

    public void increaseLoses() {
        this.loses++;
        write();
    }

    public void setCoinsWon(int coinsWon) {
        this.coinsWon += coinsWon;
        write();
    }

    public void setCoinsLost(int coinsLost) {
        this.coinsLost += coinsLost;
        write();
    }

    public void setContinuousPlays(int continuousPlays) {
        this.continuousPlays = continuousPlays;
        write();
    }

    public void increaseContinuousPlays() {
        this.continuousPlays++;
        write();
    }

    public void setCoins(int coins) {
        this.coins = coins;
        write();
    }

    public int totalGames() {
        return wins + ties + loses;
    }

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
