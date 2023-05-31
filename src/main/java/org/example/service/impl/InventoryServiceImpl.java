package org.example.service.impl;

import org.example.dao.InventoryDao;
import org.example.dto.Inventory;
import org.example.service.InventoryService;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private InventoryDao dao;
    private static final String PATH_TO_DATA_SOURCE_BEDCLOTHES = "/bedclothing.csv";
    private static final String PATH_TO_DATA_SOURCE_DISHES = "/dish.csv";

    public InventoryServiceImpl(InventoryDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Inventory> retrieveAllInventoryData() {
        return dao.retrieveAllInventoryDataFromDataSource(PATH_TO_DATA_SOURCE_BEDCLOTHES, PATH_TO_DATA_SOURCE_DISHES);
    }

    @Override
    public List<Inventory> retrieveInventoryDataFilteredByColor(String color, String type) {
        List<Inventory> all = dao.retrieveAllInventoryDataFromDataSource(PATH_TO_DATA_SOURCE_BEDCLOTHES, PATH_TO_DATA_SOURCE_DISHES);

        List<Inventory> filtered = filteredByColor(all, color, type);
        return filtered;
    }

    private List<Inventory> filteredByColor(List<Inventory> all, String color, String type) {
        List<Inventory> filtered = new ArrayList<>();
        for (Inventory inventory : all) {
            if (color.equals(inventory.getColor().toString()) &&
                    type.equals(inventory.getClass().getSimpleName())) {
                filtered.add(inventory);
            } else if (color.equals(inventory.getColor().toString()) &&
                    type.equals("All")) {
                filtered.add(inventory);
            }
        }
        return filtered;
    }

    @Override
    public List<Inventory> retrieveInventoryDataFilteredByMinMax(String min, String max, String type) {
        List<Inventory> all = dao.retrieveAllInventoryDataFromDataSource(PATH_TO_DATA_SOURCE_BEDCLOTHES, PATH_TO_DATA_SOURCE_DISHES);

        List<Inventory> filtered = filteredByMinMax(all, min, max, type);
        return filtered;
    }

    private List<Inventory> filteredByMinMax(List<Inventory> all, String min, String max, String type) {
        List<Inventory> filtered = new ArrayList<>();
        for (Inventory inventory : all) {
            if (Long.parseLong(min) <= inventory.getPrice() &&
                    inventory.getPrice() <= Long.parseLong(max)) {
                if (type.equals(inventory.getClass().getSimpleName())) {
                    filtered.add(inventory);
                } else if (type.equals("All")) {
                    filtered.add(inventory);
                }
            }
        }
        return filtered;
    }
}
