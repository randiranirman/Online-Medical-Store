package org.example.onlinemediclestore.utils;

import org.example.onlinemediclestore.Classes.Order;

public class Node {
    Order order;
    Node next;
    public Node( Order order){
        this.order =order;
        this.next= null;
    }
}
