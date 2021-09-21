package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.model.Order;
import de.neuefische.orderspringserver.model.Product;
import de.neuefische.orderspringserver.repo.OrderRepo;
import de.neuefische.orderspringserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepo orderRepo;
    private final ProductService productService;

    @Autowired
    public OrderService(OrderRepo orderRepo, ProductService productService) {
        this.orderRepo = orderRepo;
        this.productService = productService;
    }

    public List<Order> listOrders(){
        return orderRepo.listOrders();
    }

    public Order orderProducts(List<String> productIds) {
        List<Product> productsToOrder = new ArrayList<>();
        for (String productId : productIds) {
            Product productToAdd = productService.getProductById(productId);
            productsToOrder.add(productToAdd);
        }
        String id = UUID.randomUUID().toString();
        Order order = new Order(id, productsToOrder);
        return orderRepo.addOrder(order);
    }

}
