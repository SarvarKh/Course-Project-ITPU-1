package rowmapper;

import org.example.dto.Bedclothing;
import org.example.dto.Inventory;
import org.example.dto.parameters.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomStringToBedclothingDataRowMapperTest {
    @Test
    public void mapRowTest() {
        final Inventory bedclothingActual = new Bedclothing(1, 100, 3, BeddingMaterial.COTTON, Color.BLACK, Style.MODERN,
                140, 4, BeddingSize.KING, FillingMaterial.DOWN);

        String row = "1,100,3,COTTON,BLACK,MODERN,140,4,KING,DOWN";
        String[] rowList = row.split(",");
        int id = Integer.parseInt(rowList[0]);
        long price = Long.parseLong(rowList[1]);
        int weight = Integer.parseInt(rowList[2]);
        BeddingMaterial beddingMaterial = BeddingMaterial.valueOf(rowList[3]);
        Color color = Color.valueOf(rowList[4]);
        Style style = Style.valueOf(rowList[5]);
        int washingDurability = Integer.parseInt(rowList[6]);
        int storageDurability = Integer.parseInt(rowList[7]);
        BeddingSize beddingSize = BeddingSize.valueOf(rowList[8]);
        FillingMaterial fillingMaterial = FillingMaterial.valueOf(rowList[9]);

        Inventory bedclothingExpected = new Bedclothing(id, price, weight, beddingMaterial, color, style, washingDurability,
                storageDurability, beddingSize, fillingMaterial);

        Assertions.assertEquals(bedclothingExpected.getId(), bedclothingActual.getId());
    }
}
