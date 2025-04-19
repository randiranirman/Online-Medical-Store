package org.example.onlinemediclestore.utils;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericCRUD<T> {
    private final Class<T> typeParameterClass;
    private final File file;
    private final Gson gson = new Gson();

    public GenericCRUD(Class<T> typeParameterClass, String filePath) {
        this.typeParameterClass = typeParameterClass;
        this.file = new File(filePath);
    }

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
}
