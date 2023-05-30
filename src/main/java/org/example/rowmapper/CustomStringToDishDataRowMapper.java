package org.example.rowmapper;

import org.example.dto.Dish;
import org.example.dto.Inventory;
import org.example.dto.parameters.*;

public class CustomStringToDishDataRowMapper {
    public Inventory mapRaw(String[] row){
        int id = Integer.parseInt(row[0]);
        long price = Long.parseLong(row[1]);
        int weight = Integer.parseInt(row[2]);
        DishMaterial dishMaterial = DishMaterial.valueOf(row[3]);
        Color color = Color.valueOf(row[4]);
        Style style = Style.valueOf(row[5]);
        int washingDurability = Integer.parseInt(row[6]);
        int storageDurability = Integer.parseInt(row[7]);
        FoodSafety foodSafety = FoodSafety.valueOf(row[8]);
        HeatResistance heatResistance = HeatResistance.valueOf(row[9]);
        DishSize dishSize = DishSize.valueOf(row[10]);

        Inventory dish = new Dish(id, price, weight, dishMaterial, color, style, washingDurability,
        storageDurability, foodSafety, heatResistance, dishSize);

        return dish;
    };
}
