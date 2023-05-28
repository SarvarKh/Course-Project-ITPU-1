package org.example.domain;

import org.example.domain.enums.FoodSafety;
import org.example.domain.enums.HeatResistance;
import org.example.domain.enums.Material;
import org.example.domain.enums.Style;

public class Dish extends Inventory {
    private final FoodSafety foodSafety;
    private final HeatResistance heatResistance;

    public Dish(int id, long price, int weight, Material material, String color, Style style,
                FoodSafety foodSafety, HeatResistance heatResistance) {
        super(id, price, weight, material, color, style);
        this.foodSafety = foodSafety;
        this.heatResistance = heatResistance;
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
