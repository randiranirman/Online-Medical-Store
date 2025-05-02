package org.example.onlinemediclestore.Classes;

public class OTCMedicine extends  Medicine{

    public OTCMedicine(String name, Supplier supplier, String id) {
        super(name, supplier, id);
    }


    public OTCMedicine(String name, Supplier supplier, String id, String description, double price, int quantity, String imgPath, boolean isAvailable) {
        super(name, supplier, id, description, price, quantity, imgPath, isAvailable);
    }


    @Override
    public String toString() {
        return "OTC" + super.toString();
    }
}
