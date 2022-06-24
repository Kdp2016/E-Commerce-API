package com.product;

import com.common.utils.ResourceCreationResponse;
import com.product.dtos.NewProductRequest;
import com.product.dtos.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    public ProductResponse getUserById(int id) throws Exception {
        return productRepository.findById(id).map(ProductResponse::new).orElseThrow(Exception::new);
    }

    public ResourceCreationResponse createProduct(@Valid NewProductRequest newProductRequest) {
        Products newProduct = newProductRequest.extractResource();

        productRepository.save(newProduct);
        return new ResourceCreationResponse(newProduct.getId());
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);

    }
}
