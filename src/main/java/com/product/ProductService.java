package com.product;

import com.common.EntitySearcher;
import com.common.utils.ResourceCreationResponse;
import com.common.utils.exceptions.ResourceNotFoundException;
import com.product.dtos.NewProductRequest;
import com.product.dtos.ProductResponse;
import com.product.dtos.UpdateProductRequest;
import com.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final EntitySearcher entitySearcher;

    @Autowired
    public ProductService(ProductRepository productRepository, EntitySearcher entitySearcher) {

        this.productRepository = productRepository;
        this.entitySearcher = entitySearcher;
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

    public List<ProductResponse> search(Map<String, String> requestParamMap) {
        if (requestParamMap.isEmpty()) return getAllProducts();
        Set<Products> matchingUsers = entitySearcher.searchForEntity(requestParamMap, Products.class);
        if (matchingUsers.isEmpty()) throw new ResourceNotFoundException();
        return matchingUsers.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }
    public void deleteProductById(int id) {
        productRepository.deleteById(id);

    }

    public void updateProduct (@Valid UpdateProductRequest updateProductRequest) {

        Products updatedProduct = updateProductRequest.extractResource();
        Products productForUpdate = productRepository.findById(updatedProduct.getId()).orElseThrow(ResourceNotFoundException::new);

        if (updatedProduct.getBrand() != null) {
            productForUpdate.setBrand(updatedProduct.getBrand());
        }
        if (updatedProduct.getCategory() != null) {
            productForUpdate.setCategory(updatedProduct.getCategory());
        }

        if (updatedProduct.getPrice() != 0) {
            productForUpdate.setPrice(updatedProduct.getPrice());
        }

        if (updatedProduct.getProductDescription() != null) {
            productForUpdate.setProductDescription(updatedProduct.getProductDescription());
        }

        if (updatedProduct.getProductImage() != null) {
            productForUpdate.setProductImage(updatedProduct.getProductImage());
        }

        if (updatedProduct.getProductName() != null) {
            productForUpdate.setProductName(updatedProduct.getProductName());
        }
        productRepository.save(productForUpdate);
    }
}
