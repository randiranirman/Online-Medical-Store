package org.example.onlinemediclestore.FileHandlers;

import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.Interfaces.ISupplierFileHandler;
import org.example.onlinemediclestore.utils.JsonHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierFileHandler implements ISupplierFileHandler {
    private final String FILEPATH= Config.SUPPLIERS.getPath();
    @Override
    public void writeSupplierToFile(Supplier supplier) {


        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH))){
            String json = JsonHelper.toJson(supplier);
            writer.write(json);

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @Override
    public List<Supplier> readSupplierFromFile() {
        File file = new File(FILEPATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }

            return JsonHelper.fromJsonToList(jsonBuilder.toString(), Supplier.class);

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
