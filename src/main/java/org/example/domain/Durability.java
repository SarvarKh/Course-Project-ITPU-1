package org.example.domain;

public interface Durability {
    // x times can be washed
    int getWashingDurability();

    // x years can be stored
    int getStorageDurability();
}
