package com.product;

import com.common.utils.ResourceCreationResponse;
import com.product.dtos.NewProductRequest;
import com.product.dtos.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = "application/json")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/id/{productId}")
    public ProductResponse getUserById(@PathVariable int productId) throws Exception {
        return productService.getUserById(productId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse postNewUser(@RequestBody NewProductRequest newProduct) {
        return productService.createProduct(newProduct);
    }
    
    @PostMapping("/delete/{productId}")
    public void deleteProductById(@PathVariable int productId) {
        productService.deleteProductById(productId);
    }
}
