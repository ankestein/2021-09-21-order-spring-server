package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.model.Order;
import de.neuefische.orderspringserver.model.Product;
import de.neuefische.orderspringserver.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> listOrders(){
        return orderService.listOrders();
    }

    @PostMapping
    public Order orderProducts(@RequestBody List<String> productIds) {
        return orderService.orderProducts(productIds);
    }

}
