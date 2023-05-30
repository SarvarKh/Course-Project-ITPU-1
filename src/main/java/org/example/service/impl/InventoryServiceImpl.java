package org.example.service.impl;

import org.example.dao.InventoryDao;
import org.example.dto.Inventory;
import org.example.service.InventoryService;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private InventoryDao dao;

    public InventoryServiceImpl(InventoryDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Inventory> retrieveAllInventoryData() {
        return dao.retrieveAllInventoryDataFromDataSource();
    }

    @Override
    public List<Inventory> retrieveInventoryDataFilteredByColor(String color, String type) {
        List<Inventory> all = dao.retrieveAllInventoryDataFromDataSource();

        List<Inventory> filtered = filteredByColor(all, color, type);
        return filtered;
    }

    private static List<Inventory> filteredByColor(List<Inventory> all, String color, String type) {
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
}
