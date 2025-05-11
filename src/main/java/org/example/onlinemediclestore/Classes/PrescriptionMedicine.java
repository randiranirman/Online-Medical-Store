package org.example.onlinemediclestore.Classes;

public class PrescriptionMedicine extends  Medicine{
    public PrescriptionMedicine(String name, Supplier supplier, String id) {
        super(name, supplier, id);

    }

    public PrescriptionMedicine(String name, Supplier supplier, String id, String description, double price, int quantity, String imgPath, boolean isAvailable) {
        super(name, supplier, id, description, price, quantity, imgPath, isAvailable);








    }


    @Override
    public String toString() {
        return "Prescription" + super.toString();
    }

}
