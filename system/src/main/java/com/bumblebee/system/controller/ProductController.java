package com.bumblebee.system.controller;

import com.bumblebee.system.model.Product;
import com.bumblebee.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(path = "/addProducts")
    public Product createFoods(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping(path = "/getProducts")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    //	read by id
    @GetMapping(path = "/getProducts/{id}")
    public Product getProductsById(@PathVariable Long id){
        return productService.getProductsById(id);
    }
    @PutMapping(path = "/updateProducts/{id}")
    public ResponseEntity<?> updateProducts(@RequestBody Product product, @PathVariable Long id){
        Optional<Product> findProduct = Optional.ofNullable(productService.getProductsById(id));

        if(findProduct.isPresent()) {
            Product updateProduct = findProduct.get();
            updateProduct.setProductName(product.getProductName());
            updateProduct.setProductDescription(product.getProductDescription());
            updateProduct.setCategory(product.getCategory());
            updateProduct.setQuantity(product.getQuantity());
            updateProduct.setImage1(product.getImage1());
            updateProduct.setImage2(product.getImage2());
            updateProduct.setImage3(product.getImage3());
            updateProduct.setPrice(product.getPrice());
            return new ResponseEntity<>(productService.updateProducts(updateProduct), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(path="deleteProducts/{id}")
    public void deleteProducts(@PathVariable Long id){
        productService.deleteProducts(id);
    }

}
