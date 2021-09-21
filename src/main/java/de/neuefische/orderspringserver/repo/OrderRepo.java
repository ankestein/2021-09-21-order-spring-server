package de.neuefische.orderspringserver.repo;

import de.neuefische.orderspringserver.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepo {

    private final List<Order> orders = new ArrayList<>();

    public List<Order> listOrders(){
        return orders;
    }

    public Order addOrder(Order order){
        orders.add(order);
        return order;
    }
}