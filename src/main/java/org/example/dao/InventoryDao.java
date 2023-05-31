package org.example.dao;

import org.example.dto.Inventory;

import java.util.List;

public interface InventoryDao {
    List<Inventory> retrieveAllInventoryDataFromDataSource(String pathToBedclothing, String pathToDishes);
}
