package org.example.onlinemediclestore.utils;

import org.example.onlinemediclestore.Classes.Order;

public class QueueHelper {

    private Node front;
    private Node rear;


    public QueueHelper(){
        this.front = null;
        this.rear= null;

    }


    //add to queue
    public void enqueue( Order order){
        Node newNode = new Node(order);
        if( rear == null){
            front= rear= newNode;

        }else{
            rear.next= newNode;
            rear=newNode;
        }
    }
    // removing the order from the queue
    public Order dequeue(){
        if( front == null){
            System.out.println("queue is empty");
            return null;
        }
        Order removeOrder= front.order;
        front = front.next;


        if( front == null){
            rear= null;
        }
        return removeOrder;
    }
    public Order Peek(){
        return front != null ? front.order: null;
    }




}
