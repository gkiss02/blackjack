package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.*;

public class Statics {
    private JsonObject jsonObject;
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

    public void setCoins(int coins) {
        this.coins = coins;
        write();
    }

    public void write() {
        try {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("coins", coins);

            JsonObject statics = builder.build();

            JsonWriter writer = Json.createWriter(new FileOutputStream("statics.json"));
            writer.writeObject(statics);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
