package rowmapper;

import org.example.dto.Bedclothing;
import org.example.dto.Dish;
import org.example.dto.Inventory;
import org.example.dto.parameters.*;
import org.example.rowmapper.CustomStringToBedclothingDataRowMapper;
import org.example.rowmapper.CustomStringToDishDataRowMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomStringToDishDataRowMapperTest {
    private CustomStringToDishDataRowMapper rowMapper = new CustomStringToDishDataRowMapper();

    @Test
    public void mapRowTest() {
        // given
        final Inventory dishExpected = new Dish(1, 25, 3, DishMaterial.MELAMINE, Color.BLUE, Style.TRADITIONAL,
                800, 10, FoodSafety.HIGH_FOOD_GRADE, HeatResistance.EXTREME, DishSize.MEDIUM);

        String row = "1,25,3,MELAMINE,BLUE,TRADITIONAL,800,10,HIGH_FOOD_GRADE,EXTREME,MEDIUM";
        String[] rowList = row.split(",");

        // when
        Inventory dishActual = rowMapper.mapRaw(rowList);

        // then
        Assertions.assertEquals(dishExpected.getId(), dishActual.getId());
    }
}
