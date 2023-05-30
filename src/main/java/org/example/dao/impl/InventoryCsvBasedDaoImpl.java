package org.example.dao.impl;

import org.example.dao.InventoryDao;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.example.dto.Inventory;
import org.example.rowmapper.CustomStringToBedclothingDataRowMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryCsvBasedDaoImpl implements InventoryDao {
    private static final String PATH_TO_DATA_SOURCE = "/Users/sarvarkhalimov/Documents/ITPU/" +
            "Programming - Course Project/Course-Project-ITPU-1/src/main/resources/bedclothing.csv";

    @Override
    public List<Inventory> retrieveAllInventoryDataFromDataSource() {
        List<String[]> allData = fetchDataFromCsvFile();

        removeHeaderDataFromPureDataSet(allData);

        List<Inventory> dataResulted = transformStringDataIntoDtoBasedCollection(allData);
        return dataResulted;
    }

    private static List<String[]> fetchDataFromCsvFile() {
        FileReader filereader = null;
        try {
            filereader = new FileReader(PATH_TO_DATA_SOURCE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withCSVParser(parser)
                .build();

        List<String[]> allData;
        try {
            allData = csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return allData;
    }

    private List<Inventory> transformStringDataIntoDtoBasedCollection(List<String[]> allData) {
        CustomStringToBedclothingDataRowMapper rowMapper =new CustomStringToBedclothingDataRowMapper();
        List<Inventory> result = new ArrayList<>();

//        for (String[] row : allData.subList(0,5)) {
        for (String[] row : allData) {
            Inventory sd = rowMapper.mapRaw(row);

            result.add(sd);
        }
        return result;
    }

    private void removeHeaderDataFromPureDataSet(List<String[]> allData) {
        allData.remove(0);
    }
}
