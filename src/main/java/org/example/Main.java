package org.example;

import org.example.dao.InventoryDao;
import org.example.dao.impl.InventoryCsvBasedDaoImpl;
import org.example.dto.Inventory;
import org.example.dto.parameters.Color;
import org.example.service.InventoryService;
import org.example.service.impl.InventoryServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting application...\n-=-=-=-=-*****-=-=-=-=-");
        InventoryDao dao = new InventoryCsvBasedDaoImpl();
        InventoryService service = new InventoryServiceImpl(dao);
        List<String> userInput = getUserInput();

        if (userInput.size() == 0){
            System.out.println("There were no filtering params.");

            printAllDataFromTheFile(service);
        } else {
            String filteringParam = fetchFilteringParam(userInput);
            System.out.println("Color for filtering is "+ filteringParam);
            printFilteredDataByColor(service, filteringParam);
        }
    }

    private static List<String> getUserInput() throws IOException {
        System.out.println("Please, enter: \n1 to retrieve all inventory, or");
        System.out.println("2 to retrieve only specific inventories by color");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String input = reader.readLine();

        List<String> result = new ArrayList<>();
        if (input.equals("1")) {
            return result; // empty list
        }

        while (!input.equals("2")) {
            System.out.println("\n!WARNING: You entered invalid number, please only enter 1 or 2");
            getUserInput();
        }

        input = selectColor();
        result.add(input);
        return result;
    }

    private static String selectColor() throws IOException {
        System.out.println("Please, enter corresponding number to retrieve only specific inventories by its color");
        int index = 0;
        for (Color color : Color.values()) {
            System.out.println(""+index+" - " + color);
            index += 1;
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String input = reader.readLine();
        if (!input.matches("^(10|[0-9])$")) {
            System.out.println("\n!WARNING: You entered invalid number, please only enter numbers between 0 or 10");
            selectColor();
        }
        return Color.values()[Integer.parseInt(input)].toString();
    }

    private static String fetchFilteringParam(List<String> args) {
        String filteringParam = String.valueOf(args.get(0));
        return filteringParam;
    }

    private static void printFilteredDataByColor(InventoryService service, String filteringParam) {
        List<Inventory> inventoryData = service.retrieveInventoryDataFilteredByColor(filteringParam);

        for (Inventory item : inventoryData) {
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