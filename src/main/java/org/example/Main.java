package org.example;

import org.example.dao.InventoryDao;
import org.example.dao.impl.InventoryCsvBasedDaoImpl;
import org.example.dto.Inventory;
import org.example.service.InventoryService;
import org.example.service.impl.InventoryServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        InventoryDao dao = new InventoryCsvBasedDaoImpl();
        InventoryService service = new InventoryServiceImpl(dao);

        if (args.length == 0){
            System.out.println("There were no filtering params.");

            printAllDataFromTheFile(service);
        } else {
            String filteringParam = fetchFilteringParam(args);
            System.out.println("Industry code for filtering is "+ filteringParam);

            printFilteredDataByIndustryCode(service, filteringParam);
        }
    }

    private static String fetchFilteringParam(String[] args) {
        String filteringParam = String.valueOf(args[0]);
        return filteringParam;
    }

    private static void printFilteredDataByIndustryCode(InventoryService service, String filteringParam) {
        List<Inventory> surveyData = service.retrieveInventoryDataFilteredByColor(filteringParam);

        for (Inventory item : surveyData) {
            System.out.println(item);
        }
    }

    private static void printAllDataFromTheFile(InventoryService service) {
        List<Inventory> inventoryData = service.retrieveAllInventoryData();

        for (Inventory item : inventoryData) {
            System.out.println(item);
        }
    }
}