package rowmapper;

import org.example.dto.Bedclothing;
import org.example.dto.Inventory;
import org.example.dto.parameters.*;
import org.example.rowmapper.CustomStringToBedclothingDataRowMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomStringToBedclothingDataRowMapperTest {
    private CustomStringToBedclothingDataRowMapper rowMapper = new CustomStringToBedclothingDataRowMapper();

    @Test
    public void mapRowTest() {
        // given
        final Inventory bedclothingExpected = new Bedclothing(1, 100, 3, BeddingMaterial.COTTON, Color.BLACK, Style.MODERN,
                140, 4, BeddingSize.KING, FillingMaterial.DOWN);

        String row = "1,100,3,COTTON,BLACK,MODERN,140,4,KING,DOWN";
        String[] rowList = row.split(",");

        // when
        Inventory bedclothingActual = rowMapper.mapRaw(rowList);

        // then
        Assertions.assertEquals(bedclothingExpected.getId(), bedclothingActual.getId());
    }
}
