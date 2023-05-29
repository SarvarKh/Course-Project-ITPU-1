package org.example.domain;

import org.example.domain.parameters.*;

public class Bedclothing extends Inventory implements Durability {
    private final BeddingSize beddingSize;
    private final FillingMaterial fillingMaterial;

    public Bedclothing(int id, long price, int weight, Material material, Color color, Style style,
                       int washingDurability, int storageDurability, BeddingSize beddingSize, FillingMaterial fillingMaterial) {
        super(id, price, weight, material, color, style, washingDurability, storageDurability);
        this.beddingSize = beddingSize;
        this.fillingMaterial = fillingMaterial;
    }

    public BeddingSize getBeddingSize() {
        return beddingSize;
    }

    public FillingMaterial getFillingMaterial() {
        return fillingMaterial;
    }

    @Override
    public String toString() {
        return "Bedclothing{" +
                "id=" + this.getId() +
                ", price=" + this.getPrice() +
                ", weight=" + this.getWeight() +
                ", material=" + this.getMaterial() +
                ", color=" + this.getColor() +
                ", style=" + this.getStyle() +
                "beddingSize=" + beddingSize +
                ", fillingMaterial=" + fillingMaterial +
                ", washingDurability=" + this.getWashingDurability() +
                ", storageDurability=" + this.getStorageDurability() +
                '}';
    }

    @Override
    public int getWashingDurability() {
        return this.getWashingDurability();
    }

    @Override
    public int getStorageDurability() {
        return this.getStorageDurability();
    }
}
