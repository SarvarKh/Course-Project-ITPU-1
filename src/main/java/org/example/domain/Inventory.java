package org.example.domain;

import org.example.domain.parameters.Color;
import org.example.domain.parameters.Material;
import org.example.domain.parameters.Style;

import java.io.Serializable;

public abstract class Inventory implements Serializable {
    private final int id;
    private final long price;
    private final int weight;
    private final Material material;
    private final Color color;
    private final Style style;
    private final int washingDurability;
    private final int storageDurability;

    public Inventory(int id, long price, int weight, Material material, Color color, Style style,
                     int washingDurability, int storageDurability) {
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.material = material;
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

    public Material getMaterial() {
        return material;
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
                ", material=" + material +
                ", color=" + color +
                ", style=" + style +
                ", washingDurability=" + washingDurability +
                ", storageDurability=" + storageDurability +
                '}';
    }
}
