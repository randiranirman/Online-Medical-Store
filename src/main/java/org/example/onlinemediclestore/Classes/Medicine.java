package org.example.onlinemediclestore.Classes;

public class Medicine {
    private String name ;
    private Supplier supplier;
    private String supplierID;

    private String id ;
    private Double price ;
    private String description;
    private String img_path;
    private int quantity;


    private boolean isAvailable;

    public Medicine(String name ,Supplier supplier, String id,String description,double price, int quantity,String imgPath, boolean isAvailable ){
        this.name  = name;
        this.supplier= supplier;
        this.id= id;
        this.img_path= imgPath;
        this.description= description;
        this.price= price;
        this.quantity= quantity;
        this.isAvailable= isAvailable;



    }

    public Medicine(String name ,Supplier supplier, String id){
        this.name= name;
        this.supplier= supplier;
        this.id= id;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImg_path() {
        return img_path;
    }



    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", medicineName='" + name + '\'' +
                ", quantity=" + quantity +
                ", supplier='" + supplier + '\'' +
                ", description=" + description +
                ", isavailbale=" + isAvailable +
                ", price=" + price +
                ", imgPath='" + img_path + '\'' +

                '}';
    }
}
