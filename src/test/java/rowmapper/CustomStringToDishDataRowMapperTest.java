package rowmapper;

import org.example.dto.Bedclothing;
import org.example.dto.Dish;
import org.example.dto.Inventory;
import org.example.dto.parameters.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomStringToDishDataRowMapperTest {
    @Test
    public void mapRowTest() {
        final Inventory dishActual = new Dish(1, 25, 3, DishMaterial.MELAMINE, Color.BLUE, Style.TRADITIONAL,
                800, 10, FoodSafety.HIGH_FOOD_GRADE, HeatResistance.EXTREME, DishSize.MEDIUM);

        String row = "1,25,3,MELAMINE,BLUE,TRADITIONAL,800,10,HIGH_FOOD_GRADE,EXTREME,MEDIUM";
        String[] rowList = row.split(",");
        int id = Integer.parseInt(rowList[0]);
        long price = Long.parseLong(rowList[1]);
        int weight = Integer.parseInt(rowList[2]);
        DishMaterial dishMaterial = DishMaterial.valueOf(rowList[3]);
        Color color = Color.valueOf(rowList[4]);
        Style style = Style.valueOf(rowList[5]);
        int washingDurability = Integer.parseInt(rowList[6]);
        int storageDurability = Integer.parseInt(rowList[7]);
        FoodSafety foodSafety = FoodSafety.valueOf(rowList[8]);
        HeatResistance heatResistance = HeatResistance.valueOf(rowList[9]);
        DishSize dishSize = DishSize.valueOf(rowList[10]);

        Inventory dishExpected = new Dish(id, price, weight, dishMaterial, color, style, washingDurability,
                storageDurability, foodSafety, heatResistance, dishSize);

        Assertions.assertEquals(dishExpected.getPrice(), dishActual.getPrice());
    }
}
