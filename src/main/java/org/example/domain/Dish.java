package org.example.domain;

import org.example.domain.enums.*;

public class Dish extends Inventory {
    private final FoodSafety foodSafety;
    private final HeatResistance heatResistance;
    private final DishSize dishSize;

    public Dish(int id, long price, int weight, Material material, String color, Style style,
                FoodSafety foodSafety, HeatResistance heatResistance, DishSize dishSize) {
        super(id, price, weight, material, color, style);
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

    @Override
    public String toString() {
        return "Dish{" +
                "foodSafety=" + foodSafety +
                ", heatResistance=" + heatResistance +
                '}';
    }
}
