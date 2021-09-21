package de.neuefische.orderspringserver.repo;

import de.neuefische.orderspringserver.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo {

    private List<Product> products = List.of(
            new Product("1", "t-shirt"),
            new Product("2", "socks"),
            new Product("3", "trousers"),
            new Product("4", "gloves")
    );

    public List<Product> listProducts() {
        return products;
    }

    public Optional<Product> getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
     }

    public List<Product> getProductByName(String search) {
        List<Product> productsWithMatchingName = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(search)) {
                productsWithMatchingName.add(product);
            }
        }
        return productsWithMatchingName;
    }


}