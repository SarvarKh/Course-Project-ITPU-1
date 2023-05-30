package org.example.dto;

import org.example.dto.parameters.*;

public class Dish extends Inventory implements Durability {
    private final FoodSafety foodSafety;
    private final HeatResistance heatResistance;
    private final DishSize dishSize;
    private final DishMaterial dishMaterial;

    public Dish(int id, long price, int weight, DishMaterial dishMaterial, Color color, Style style, int washingDurability,
                int storageDurability, FoodSafety foodSafety, HeatResistance heatResistance, DishSize dishSize) {
        super(id, price, weight, color, style, washingDurability, storageDurability);
        this.foodSafety = foodSafety;
        this.heatResistance = heatResistance;
        this.dishSize = dishSize;
        this.dishMaterial = dishMaterial;
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

    public DishMaterial getDishMaterial() { return dishMaterial; }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + this.getId() +
                ", price=" + this.getPrice() +
                ", weight=" + this.getWeight() +
                ", dishMaterial=" + dishMaterial +
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
        return super.getWashingDurability();
    }

    @Override
    public int getStorageDurability() {
        return super.getStorageDurability();
    }
}
