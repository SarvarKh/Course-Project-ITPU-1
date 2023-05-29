package org.example.domain;

import org.example.domain.parameters.*;

public class Dish extends Inventory implements Durability {
    private final FoodSafety foodSafety;
    private final HeatResistance heatResistance;
    private final DishSize dishSize;

    public Dish(int id, long price, int weight, Material material, Color color, Style style, int washingDurability,
                int storageDurability, FoodSafety foodSafety, HeatResistance heatResistance, DishSize dishSize) {
        super(id, price, weight, material, color, style, washingDurability, storageDurability);
        this.foodSafety = foodSafety;
        this.heatResistance = heatResistance;
        this.dishSize = dishSize;
    }

    public FoodSafety getFoodSafety() {
        return foodSafety;
    }

    public HeatResistance getHeatResistance() {
        return heatResistance;
    }

    public DishSize getDishSize() {
        return dishSize;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + this.getId() +
                ", price=" + this.getPrice() +
                ", weight=" + this.getWeight() +
                ", material=" + this.getMaterial() +
                ", color=" + this.getColor() +
                ", style=" + this.getStyle() +
                "foodSafety=" + foodSafety +
                ", heatResistance=" + heatResistance +
                ", washingDurability=" + this.getWashingDurability() +
                ", storageDurability=" + this.getStorageDurability() +
                '}';
    }

    @Override
    public int getWashingDurability() {
        return this.getWashingDurability();
    }

    @Override
    public int getStorageDurability() {
        return this.getStorageDurability();
    }
}
