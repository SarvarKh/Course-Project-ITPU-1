package org.example;

import org.example.controller.ConsoleController;
import org.example.dao.InventoryDao;
import org.example.dao.impl.InventoryCsvBasedDaoImpl;
import org.example.service.InventoryService;
import org.example.service.impl.InventoryServiceImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting application...\n-=-=-=-=-*****-=-=-=-=-");
        InventoryDao dao = new InventoryCsvBasedDaoImpl();
        InventoryService service = new InventoryServiceImpl(dao);
        List<String> userInput = ConsoleController.getUserInput();

        if (userInput.size() == 0){
            System.out.println("There were no filtering params.");

            ConsoleController.printAllDataFromTheFile(service);
        } else if (userInput.size() == 2) {
            String filteringColorParam = String.valueOf(userInput.get(0));
            String filteringTypeParam = String.valueOf(userInput.get(1));
            System.out.println("Filtering color is "+ filteringColorParam + " and type is " + filteringTypeParam);
            ConsoleController.printFilteredDataByColorAndType(service, filteringColorParam, filteringTypeParam);
        } else {
            // Search by price will have list.size() == 3 (min, max, inventType)
            String filteringMinParam = String.valueOf(userInput.get(0));
            String filteringMaxParam = String.valueOf(userInput.get(1));
            String filteringTypeParam = String.valueOf(userInput.get(2));
            System.out.println("Filtering min is "+ filteringMinParam + ", max is " + filteringMaxParam +
                    " and type is " +filteringTypeParam);
            ConsoleController.printFilteredDataByMinMaxType(service, filteringMinParam, filteringMaxParam, filteringTypeParam);
        }
    }



}