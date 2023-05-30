package org.example.dao.impl;

import org.example.dao.InventoryDao;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.example.dto.Inventory;
import org.example.rowmapper.CustomStringToBedclothingDataRowMapper;
import org.example.rowmapper.CustomStringToDishDataRowMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryCsvBasedDaoImpl implements InventoryDao {
    private static final String PATH_TO_DATA_SOURCE_BEDCLOTHES = "/Users/sarvarkhalimov/Documents/ITPU/" +
            "Programming - Course Project/Course-Project-ITPU-1/src/main/resources/bedclothing.csv";

    private static final String PATH_TO_DATA_SOURCE_DISHES = "/Users/sarvarkhalimov/Documents/ITPU/" +
            "Programming - Course Project/Course-Project-ITPU-1/src/main/resources/dish.csv";

    @Override
    public List<Inventory> retrieveAllInventoryDataFromDataSource() {
        List<String[]> allDataBedclothing = fetchDataFromCsvFile(PATH_TO_DATA_SOURCE_BEDCLOTHES);
        List<String[]> allDataDish = fetchDataFromCsvFile(PATH_TO_DATA_SOURCE_DISHES);

        removeHeaderDataFromPureDataSet(allDataBedclothing);
        removeHeaderDataFromPureDataSet(allDataDish);

        List<Inventory> dataResultedBedclothing = transformStringBedclothingDataIntoDtoBasedCollection(allDataBedclothing);
        List<Inventory> dataResultedDish = transformStringDishDataIntoDtoBasedCollection(allDataDish);

        List<Inventory> combinedList = new ArrayList<>();
        combinedList.addAll(dataResultedBedclothing);
        combinedList.addAll(dataResultedDish);
        return combinedList;
    }

    private static List<String[]> fetchDataFromCsvFile(String path) {
        FileReader filereader = null;
        try {
            filereader = new FileReader(path);
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

    private List<Inventory> transformStringBedclothingDataIntoDtoBasedCollection(List<String[]> allData) {
        CustomStringToBedclothingDataRowMapper rowMapper =new CustomStringToBedclothingDataRowMapper();
        List<Inventory> result = new ArrayList<>();

//        for (String[] row : allData.subList(0,5)) {
        for (String[] row : allData) {
            Inventory sd = rowMapper.mapRaw(row);

            result.add(sd);
        }
        return result;
    }

    private List<Inventory> transformStringDishDataIntoDtoBasedCollection(List<String[]> allData) {
        CustomStringToDishDataRowMapper rowMapper = new CustomStringToDishDataRowMapper();
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
