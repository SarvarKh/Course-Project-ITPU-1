package org.example.domain;

import org.example.domain.enums.Material;
import org.example.domain.enums.BeddingSize;
import org.example.domain.enums.Style;

import java.io.Serializable;

public abstract class Inventory implements Serializable {
    private int id;
    private long price;
    private int weight;
    private Material material;
    private String color;
    private Style style;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "price=" + price +
                ", weight=" + weight +
                ", material=" + material +
                ", color='" + color + '\'' +
                ", style=" + style +
                '}';
    }
}
