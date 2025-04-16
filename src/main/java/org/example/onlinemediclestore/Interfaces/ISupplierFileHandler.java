package org.example.onlinemediclestore.Interfaces;

import org.example.onlinemediclestore.Classes.Supplier;

import java.util.List;

public interface ISupplierFileHandler {
    void writeSupplierToFile (Supplier supplier);
    List<Supplier> readSupplierFromFile();



}
