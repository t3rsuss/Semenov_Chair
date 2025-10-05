package com.example.semenov_chair.model;

import java.io.Serializable;

public class Chair implements Serializable {
    private String material;
    private String color;
    private int height;
    private float price;
    private boolean hasArmrests;

    public Chair() {
    }

    public Chair(String material, String color, int height, float price, boolean hasArmrests) {
        this.material = material;
        this.color = color;
        this.height = height;
        this.price = price;
        this.hasArmrests = hasArmrests;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isHasArmrests() {
        return hasArmrests;
    }

    public void setHasArmrests(boolean hasArmrests) {
        this.hasArmrests = hasArmrests;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                ", price=" + price +
                ", hasArmrests=" + hasArmrests +
                '}';
    }
}
