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

    public Inventory(int id, long price, int weight, Material material, Color color, Style style) {
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.material = material;
        this.color = color;
        this.style = style;
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

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", price=" + price +
                ", weight=" + weight +
                ", material=" + material +
                ", color=" + color +
                ", style=" + style +
                '}';
    }
}
