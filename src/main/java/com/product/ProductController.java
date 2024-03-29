package com.product;

import com.common.utils.ResourceCreationResponse;
import com.product.dtos.NewProductRequest;
import com.product.dtos.ProductResponse;
import com.product.dtos.UpdateProductRequest;
import com.user.dtos.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/active")
    public List<ProductResponse> getActiveProducts() {
        return productService.activeFilter();
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

    @GetMapping("/search")
    public List<ProductResponse> findBy(@RequestParam Map<String, String> params) {
        return productService.search(params);
    }
    
//    @PostMapping("/delete/{productId}")
//    public void deleteProductById(@PathVariable int productId) {
//        productService.deleteProductById(productId);
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateProductInfo(@RequestBody UpdateProductRequest updateProductInfo) {
        productService.updateProduct(updateProductInfo);
    }

    @PatchMapping("/activation/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //    @Secured(allowedRoles = {"ADMIN"})
    public void activateUser(@RequestParam int id) {
        productService.activateProduct(id);
    }

    @DeleteMapping("/delete/")
//    @Secured(allowedRoles = {"ADMIN"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateUser(@RequestParam int id) {
        productService.deactivateProduct(id);
    }
}
