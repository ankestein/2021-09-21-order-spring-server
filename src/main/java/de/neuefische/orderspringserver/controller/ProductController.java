package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.model.Product;
import de.neuefische.orderspringserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProductsByName(@RequestParam Optional<String> search) {
        if (search.isPresent()) {
            return productService.getProductByName(search.get());
        }
        return productService.list();
    }

}
