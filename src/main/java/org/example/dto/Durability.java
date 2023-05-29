package org.example.dto;

public interface Durability {
    // x times can be washed
    int getWashingDurability();

    // x years can be stored
    int getStorageDurability();
}
