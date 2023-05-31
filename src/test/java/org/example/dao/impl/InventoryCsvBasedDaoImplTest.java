package org.example.dao.impl;

import org.example.dto.Bedclothing;
import org.example.dto.Dish;
import org.example.dto.Inventory;
import org.example.dto.parameters.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryCsvBasedDaoImplTest {
    private InventoryCsvBasedDaoImpl impl = new InventoryCsvBasedDaoImpl();

    @Test
    void retrieveAllInventoryDataFromDataSource() {
        // given
        String PATH_BEDCLOTHES = "/bedclothing.csv";
        String PATH_DISHES = "/dish.csv";
        final List<Inventory> inventoryListExpected = new ArrayList<>();
        inventoryListExpected.add(new Bedclothing(1, 111, 1, BeddingMaterial.COTTON, Color.RED,
                Style.MODERN, 100, 3, BeddingSize.TWIN, FillingMaterial.DOWN));
        inventoryListExpected.add(new Bedclothing(2, 222, 1, BeddingMaterial.SILK, Color.ORANGE,
                Style.TRADITIONAL, 150, 4, BeddingSize.KING, FillingMaterial.FEATHERS));
        inventoryListExpected.add(new Dish(1, 22, 2, DishMaterial.EARTHENWARE, Color.RED,
                Style.MODERN, 1000, 15, FoodSafety.HIGH_FOOD_GRADE, HeatResistance.EXTREME, DishSize.SMALL));
        inventoryListExpected.add(new Dish(2, 33, 3, DishMaterial.PORCELAIN, Color.ORANGE,
                Style.MODERN, 1200, 17, FoodSafety.MEDIUM_NON_ALLERGENIC, HeatResistance.HIGH, DishSize.MEDIUM));

        // when
        List<Inventory> inventoryListActual = impl.retrieveAllInventoryDataFromDataSource(PATH_BEDCLOTHES, PATH_DISHES);

        // then
        Assertions.assertEquals(inventoryListExpected.get(0).getWeight(), inventoryListActual.get(0).getWeight());
    }

    @Test
    void retrieveAllInventoryDataFromDataSourceWhenNoResource() {
        // given
        String PATH_BEDCLOTHES = "/non-existing1.csv";
        String PATH_DISHES = "/non-existing2.csv";

        // then
        assertThrows(RuntimeException.class, () -> impl.retrieveAllInventoryDataFromDataSource(PATH_BEDCLOTHES, PATH_DISHES));
    }
}