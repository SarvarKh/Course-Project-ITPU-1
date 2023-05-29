package org.example.domain;

import org.example.domain.parameters.Color;
import org.example.domain.parameters.BeddingMaterial;
import org.example.domain.parameters.Style;

import java.io.Serializable;

public abstract class Inventory implements Serializable {
    private final int id;
    private final long price;
    private final int weight;
    private final Color color;
    private final Style style;
    private final int washingDurability; // x times can be washed
    private final int storageDurability; // x years can be stored

    public Inventory(int id, long price, int weight, Color color, Style style,
                     int washingDurability, int storageDurability) {
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.style = style;
        this.washingDurability = washingDurability;
        this.storageDurability = storageDurability;
    }

    public int getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public Style getStyle() {
        return style;
    }

    public int getWashingDurability() {
        return washingDurability;
    }

    public int getStorageDurability() {
        return storageDurability;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", price=" + price +
                ", weight=" + weight +
                ", color=" + color +
                ", style=" + style +
                ", washingDurability=" + washingDurability +
                ", storageDurability=" + storageDurability +
                '}';
    }
}
