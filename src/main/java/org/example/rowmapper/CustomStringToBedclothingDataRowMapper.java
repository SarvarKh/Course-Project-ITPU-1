package org.example.rowmapper;

import org.example.dto.Bedclothing;
import org.example.dto.Inventory;
import org.example.dto.parameters.*;

public class CustomStringToBedclothingDataRowMapper {
    public Inventory mapRaw(String[] row){
        int id = Integer.parseInt(row[0]);
        long price = Long.parseLong(row[1]);
        int weight = Integer.parseInt(row[2]);
        BeddingMaterial beddingMaterial = BeddingMaterial.valueOf(row[3]);
        Color color = Color.valueOf(row[4]);
        Style style = Style.valueOf(row[5]);
        int washingDurability = Integer.parseInt(row[6]);
        int storageDurability = Integer.parseInt(row[7]);
        BeddingSize beddingSize = BeddingSize.valueOf(row[8]);
        FillingMaterial fillingMaterial = FillingMaterial.valueOf(row[9]);

        Inventory bedclothing = new Bedclothing(id, price, weight, beddingMaterial, color, style, washingDurability,
                storageDurability, beddingSize, fillingMaterial);


        return bedclothing;
    };
}
