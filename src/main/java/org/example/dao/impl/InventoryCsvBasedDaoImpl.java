package org.example.dao.impl;

import org.example.dao.InventoryDao;
import org.example.dto.Inventory;
import org.example.rowmapper.CustomStringToBedclothingDataRowMapper;
import org.example.rowmapper.CustomStringToDishDataRowMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InventoryCsvBasedDaoImpl implements InventoryDao {
    private static final String PATH_TO_DATA_SOURCE_BEDCLOTHES = "/bedclothing.csv";

    private static final String PATH_TO_DATA_SOURCE_DISHES = "/dish.csv";

    @Override
    public List<Inventory> retrieveAllInventoryDataFromDataSource() {
        List<String[]> allDataBedclothing = removeHeaderDataFromPureDataSet(fetchDataFromCsvFile(PATH_TO_DATA_SOURCE_BEDCLOTHES));
        List<String[]> allDataDish = removeHeaderDataFromPureDataSet(fetchDataFromCsvFile(PATH_TO_DATA_SOURCE_DISHES));

        List<Inventory> dataResultedBedclothing = transformStringBedclothingDataIntoDtoBasedCollection(allDataBedclothing);
        List<Inventory> dataResultedDish = transformStringDishDataIntoDtoBasedCollection(allDataDish);

        List<Inventory> combinedList = new ArrayList<>();
        combinedList.addAll(dataResultedBedclothing);
        combinedList.addAll(dataResultedDish);
        return combinedList;
    }

    private static List<String[]> fetchDataFromCsvFile(String path) {
        try {
            return Files.readAllLines(Path.of(InventoryCsvBasedDaoImpl.class.getResource(path).toURI()))
                    .stream()
                    .map(s-> s.split(";"))
                    .toList();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
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

    private List<String[]> removeHeaderDataFromPureDataSet(List<String[]> allData) {
        return allData.subList(1, allData.size());
    }
}
