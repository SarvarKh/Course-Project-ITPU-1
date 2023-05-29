package org.example.domain;

import org.example.domain.parameters.BeddingSize;
import org.example.domain.parameters.FillingMaterial;
import org.example.domain.parameters.Material;
import org.example.domain.parameters.Style;

public class Bedclothing extends Inventory {
    private final BeddingSize beddingSize;
    private final FillingMaterial fillingMaterial;

    public Bedclothing(int id, long price, int weight, Material material, String color,
                       Style style, BeddingSize beddingSize, FillingMaterial fillingMaterial) {
        super(id, price, weight, material, color, style);
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
                "beddingSize=" + beddingSize +
                ", fillingMaterial=" + fillingMaterial +
                '}';
    }
}
