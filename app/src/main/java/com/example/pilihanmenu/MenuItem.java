package com.example.pilihanmenu;

public class MenuItem {
    private int imageResourceId;
    private String name;
    private String description;
    private int price;

    public MenuItem(int imageResourceId, String name, String description, int price) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
