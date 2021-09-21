package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.model.Order;
import de.neuefische.orderspringserver.model.Product;
import de.neuefische.orderspringserver.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> list() {
        return productRepo.listProducts();
    }

    public Product getProductById(String id) {
        Optional<Product> optionalProduct = productRepo.getProductById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new IllegalArgumentException("Product with ID " + id + " not found");
        }
    }

    public List<Product> getProductByName(String name) {
        return productRepo.getProductByName(name);
    }

}
