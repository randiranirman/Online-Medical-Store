package org.example.onlinemediclestore.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import org.example.onlinemediclestore.Classes.Customer;
import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.Classes.User;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericCRUD<T > {
    private final Class<T> typeParameterClass;
    private final File file;


    public GenericCRUD(Class<T> typeParameterClass, String filePath) {
        this.typeParameterClass = typeParameterClass;
        this.file = new File(filePath);
    }
    // Use this Gson instance everywhere
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateAdaptory())
            .setPrettyPrinting()
            .create();

    public List<T> readAll() {
        try (Reader reader = new FileReader(file)) {
            Type listType = TypeToken.getParameterized(List.class, typeParameterClass).getType();
            List<T> dataList = gson.fromJson(reader, listType);
            return dataList != null ? dataList : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void writeAll(List<T> dataList) {
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(dataList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> getAll() {
        return readAll();
    }

    public void add(T newItem) {
        List<T> items = readAll();
        items.add(newItem);
        writeAll(items);
    }

    public void update(java.util.function.Predicate<T> predicate, T updatedItem) {
        List<T> items = readAll();
        for (int i = 0; i < items.size(); i++) {
            if (predicate.test(items.get(i))) {
                items.set(i, updatedItem);
                break;
            }
        }
        writeAll(items);
    }

    public void delete(java.util.function.Predicate<T> predicate) {
        List<T> items = readAll();
        items.removeIf(predicate);
        writeAll(items);
    }


    public Optional<T> get(java.util.function.Predicate<T> predicate) {
        return readAll().stream().filter(predicate).findFirst();
    }


    public Optional<T> findOne(String username) {
        return readAll().stream()
                .filter(item -> {
                    if (item instanceof User) {
                        return username.equals(((Supplier) item).getUsername());
                    }
                    return false;
                })
                .findFirst();
    }
    public Optional<T> findOneById(String id) {
        List<T> items = readAll();
        return items.stream()
                .filter(item -> {
                    try {
                        // Assumes your model (e.g., Medicine) has a method getId()
                        return item.getClass().getMethod("getId").invoke(item).equals(id);
                    } catch (Exception e) {
                        return false;
                    }
                })
                .findFirst();
    }
    public void deleteById(java.util.function.Predicate<T> predicate) {
        List<T> items = readAll();
        items.removeIf(predicate); // Remove the item(s) matching the predicate
        writeAll(items);
    }


}
