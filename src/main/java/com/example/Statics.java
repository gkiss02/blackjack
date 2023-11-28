package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.json.*;

public class Statics {
    private int coins;

    public Statics() {
        try {
            JsonReader reader = Json.createReader(new FileInputStream("statics.json"));
            JsonObject statics = reader.readObject();
            reader.close();

            coins = Integer.parseInt(statics.get("coins").toString());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public int getCoins() {
        return coins;
    }
}
