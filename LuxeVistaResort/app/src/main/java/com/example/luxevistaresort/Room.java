package com.example.luxevistaresort;

public class Room {
    private String name;
    private String image; // URL or resource name

    private String description;

    private String price;

    public Room() {} // Required for Firestore

    public Room(String name, String image) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public String getName() { return name; }
    public String getImage() { return image; }
    public String getDescription(){return description; }
    public String getPrice(){return price; }
}
