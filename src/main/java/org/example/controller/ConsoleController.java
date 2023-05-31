package org.example.controller;

import org.example.dto.Inventory;
import org.example.dto.parameters.Color;
import org.example.service.InventoryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleController {
    public static List<String> getUserInput() throws IOException {
        System.out.println("Please, enter: \n1 to retrieve all inventory, or" +
                "\n2 to retrieve only specific inventories by color and type" +
                "\n3 to retrieve only specific inventories by min & max price");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String input = reader.readLine();

        List<String> result = new ArrayList<>();
        if (input.equals("1")) {
            return result; // empty list
        } else if (input.equals("2")) {
            result = selectColorAndInventType();
        } else if (input.equals("3")) {
            result = selectMinMaxType();
        } else {
            System.out.println("\n!WARNING: You entered invalid number, please only enter 1 or 2");
            getUserInput();
        }

        return result;
    }

    private static List<String> selectColorAndInventType() throws IOException {
        // Select Color
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
            System.out.println("\n!WARNING: You entered invalid number, please only enter numbers between 0 and 10");
            selectColorAndInventType();
        }
        String color = Color.values()[Integer.parseInt(input)].toString();

        String inventoryType = selectInventoryType();

        return new ArrayList<>(Arrays.asList(color, inventoryType));
    }

    private static List<String> selectMinMaxType() throws IOException {
        String min = selectInputMinMax("min");
        String max = selectInputMinMax("max");
        String type = selectInventoryType();

        return new ArrayList<>(Arrays.asList(min, max, type));
    }

    private static String selectInventoryType() throws IOException {
        System.out.println("Now enter type of inventory you want to retrieve:" +
                "\n1 - All" +
                "\n2 - Bedclothing" +
                "\n3 - Dishes");
        BufferedReader reader2 = new BufferedReader(
                new InputStreamReader(System.in));
        String input2 = reader2.readLine();
        if (!input2.matches("^([1-3])$")) {
            System.out.println("\n!WARNING: You entered invalid number, please only enter numbers between 1 and 3");
            selectInventoryType();
        }
        String inventoryType = "All";
        if (input2.equals("2")) {
            inventoryType = "Bedclothing";
        } else if (input2.equals("3")) {
            inventoryType = "Dish";
        }
        return inventoryType;
    }

    private static String selectInputMinMax(String parameter) throws IOException {
        System.out.println("Enter " + parameter + " value");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String input = reader.readLine();
        if (!input.matches("^[1-9][0-9]*$")) {
            System.out.println("\n!WARNING: You entered invalid input, please only enter numbers (no letters, symbols, etc.)");
            selectInputMinMax(parameter);
        }
        return input;
    }

    public static void printFilteredDataByColorAndType(InventoryService service, String filteringColorParam, String filteringTypeParam) {
        List<Inventory> inventoryData = service.retrieveInventoryDataFilteredByColor(filteringColorParam, filteringTypeParam);

        for (Inventory item : inventoryData) {
            System.out.println(item);
        }
    }

    public static void printFilteredDataByMinMaxType(InventoryService service, String filteringMinParam, String filteringMaxParam, String filteringTypeParam) {
        List<Inventory> inventoryData = service.retrieveInventoryDataFilteredByMinMax(filteringMinParam, filteringMaxParam, filteringTypeParam);

        for (Inventory item : inventoryData) {
            System.out.println(item);
        }
    }

    public static void printAllDataFromTheFile(InventoryService service) {
        List<Inventory> inventoryData = service.retrieveAllInventoryData();

        for (Inventory item : inventoryData) {
            System.out.println(item);
        }
    }
}
