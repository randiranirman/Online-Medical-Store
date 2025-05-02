package org.example.onlinemediclestore.FileConfig;

public enum Config {

    USERS("medicare/usersDetails.json"),
    TRANSACTIONS("medicare/transactions.json"),
    REVIEWS("medicare/reviews.json"),
    ADMINS("medicare/admins.json"),
    ORDERS("medicare/orders.json"),
    SUPPLIERS("medicare/suppliers.json"),
    UPLOAD_DIR("C:\\Users\\binad\\Documents\\SLIT-projects\\Online-Medicle-Store\\src\\main\\webapp\\uploads\\"),
    MEDICINES("medicare/medicines.json");

    private final String path;

    Config(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
