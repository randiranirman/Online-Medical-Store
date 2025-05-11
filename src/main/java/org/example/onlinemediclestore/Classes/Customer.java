    package org.example.onlinemediclestore.Classes;

    import java.util.ArrayList;
    import java.util.List;

    public class Customer extends  User{

        private List<Order> orders;




        public Customer(String id ,String name, String username, String password, String role,String email) {
            super(id ,name, username, password, role,email);
            this.orders= new ArrayList<>();
        }

        public List<Order> getOrders() {
            return orders;
        }


        public Customer(String id, String updatedUsername, String name, String email) {
            super(id,updatedUsername, name,null,"customer", email);
            this.orders= new ArrayList<>();
        }


    }