package org.example.onlinemediclestore.FileHandlers;

import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.Interfaces.ISupplierFileHandler;
import org.example.onlinemediclestore.utils.JsonHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierFileHandler implements ISupplierFileHandler {

    private final String FILEPATH = Config.SUPPLIERS.getPath();

    @Override
    public void writeSupplierToFile(Supplier supplier) {
        try {
            File file = new File(FILEPATH);
            File parentDir = file.getParentFile();

            // Create directory if it doesn't exist
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Create file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            List<Supplier> supplierList = readSupplierFromFile();
            supplierList.add(supplier); // Add new supplier

            String json = JsonHelper.toJson(supplierList);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(json);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Supplier> readSupplierFromFile() {
        File file = new File(FILEPATH);

        try {
            // Create file if it doesn't exist
            if (!file.exists()) {
                File parentDir = file.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs();
                }
                file.createNewFile();
                return new ArrayList<>(); // Return empty list if file is newly created
            }

            // Read file contents
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }

            reader.close();

            String json = jsonBuilder.toString();
            if (json.isEmpty()) {
                return new ArrayList<>();
            }

            return JsonHelper.fromJsonToList(json, Supplier.class);

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
