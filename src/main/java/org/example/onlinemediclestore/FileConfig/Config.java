package org.example.onlinemediclestore.FileConfig;

public enum Config {

    USERS("medicare/usersDetails.json"),
    TRANSACTIONS("medicare/transactions.json"),
    ORDERS("medicare/orders.json"),
    SUPPLIERS("medicare/suppliers.json"),
    UPLOAD_DIR("medicare/uploads/"),
    MEDICINES("medicare/medicines.json");

    private final String path;

    Config(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
