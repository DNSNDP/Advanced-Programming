package com.bumblebee.system.service;


import com.bumblebee.system.model.Product;
import com.bumblebee.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product createProduct(Product product){
       return productRepository.save(product);
    }
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    public Product getProductsById(Long id){
        return productRepository.findById(id).get();
    }

    public Product updateProducts(Product product){
        return productRepository.save(product);
    }
    public void deleteProducts(Long id){
        productRepository.deleteById(id);
    }

}
