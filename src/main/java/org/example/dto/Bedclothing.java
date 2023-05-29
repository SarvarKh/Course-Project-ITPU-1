package org.example.dto;

import org.example.dto.parameters.*;

public class Bedclothing extends Inventory implements Durability {
    private final BeddingSize beddingSize;
    private final FillingMaterial fillingMaterial;
    private final BeddingMaterial beddingMaterial;

    public Bedclothing(int id, long price, int weight, BeddingMaterial beddingMaterial, Color color, Style style,
                       int washingDurability, int storageDurability, BeddingSize beddingSize, FillingMaterial fillingMaterial) {
        super(id, price, weight, color, style, washingDurability, storageDurability);
        this.beddingMaterial = beddingMaterial;
        this.beddingSize = beddingSize;
        this.fillingMaterial = fillingMaterial;
    }

    public BeddingSize getBeddingSize() {
        return beddingSize;
    }

    public FillingMaterial getFillingMaterial() {
        return fillingMaterial;
    }

    public BeddingMaterial getBeddingMaterial() { return beddingMaterial; }

    @Override
    public String toString() {
        return "Bedclothing{" +
                "id=" + this.getId() +
                ", price=" + this.getPrice() +
                ", weight=" + this.getWeight() +
                ", beddingMaterial=" + beddingMaterial +
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
