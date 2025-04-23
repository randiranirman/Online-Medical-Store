package org.example.onlinemediclestore.Classes;

public class Medicine {
    private String name ;
    private Supplier supplier;
    private String id ;
    private Double price ;


    private boolean isAvailable;

    public Medicine(String name ,  Supplier supplier, String id ){
        this.name  = name;
        this.supplier= supplier;
        this.id= id;
    }

    public Double getPrice() {
        return price;
    }


}
