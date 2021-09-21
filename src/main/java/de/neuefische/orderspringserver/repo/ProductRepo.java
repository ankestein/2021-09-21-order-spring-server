package de.neuefische.orderspringserver.repo;

import de.neuefische.orderspringserver.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductRepo {
    private final List<Product> products;

    public ProductRepo(List<Product> products) {
        this.products = Collections.unmodifiableList(products);
    }

    public List<Product> listProducts() {
        return products;
    }

    public Optional<Product> getProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();

    }
}