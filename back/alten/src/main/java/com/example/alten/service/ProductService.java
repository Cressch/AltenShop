package com.example.alten.service;

import com.example.alten.exception.productNoFoundException;
import com.example.alten.model.Product;
import com.example.alten.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){
            product.setCode(UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public Product findProductById(Long id) throws Throwable {
        return productRepo.findProductById(id).orElseThrow(() -> new productNoFoundException("Product by id " + id + " was not found"));
    }

    public void deleteProduct(Long id){
        productRepo.deleteProductById(id);
    }
}
