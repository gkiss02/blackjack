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

    public Statics() {
        try {
            JsonReader reader = Json.createReader(new FileInputStream("statics.json"));
            JsonObject statics = reader.readObject();
            reader.close();

            coins = Integer.parseInt(statics.get("coins").toString());
            lastLogin = LocalDate.parse(statics.get("lastLogin").toString().substring(1, 11));
            continuousPlays = Integer.parseInt(statics.get("continuousPlays").toString());
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

    public void write() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("coins", coins);
            builder.add("lastLogin", LocalDateTime.now().format(dateFormat).toString());
            builder.add("continuousPlays", continuousPlays);

            JsonObject statics = builder.build();

            JsonWriter writer = Json.createWriter(new FileOutputStream("statics.json"));
            writer.writeObject(statics);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
