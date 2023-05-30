package org.example.service;

import org.example.dto.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> retrieveAllInventoryData();

    List<Inventory> retrieveInventoryDataFilteredByColor(String color, String type);
}
