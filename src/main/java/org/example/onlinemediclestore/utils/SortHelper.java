package org.example.onlinemediclestore.utils;

import org.example.onlinemediclestore.Classes.Medicine;

import java.util.List;

public class SortHelper {
    public static void quickSortByPrice(List<Medicine> medicines, int low, int high) {
        if (low < high) {
            int pi = partition(medicines, low, high);
            quickSortByPrice(medicines, low, pi - 1);
            quickSortByPrice(medicines, pi + 1, high);
        }
    }

    private static int partition(List<Medicine> list, int low, int high) {
        double pivot = list.get(high).getPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).getPrice() <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Medicine> list, int i, int j) {
        Medicine temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
