package com.imedia24.demo.service;

import com.imedia24.demo.models.Product;
import com.imedia24.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(long id){
        return productRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found")
        );
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByPrice(double price){
        return productRepository.findAllByPrice(price);
    }

    public List<Product> getProductsByName(String productName){
        return productRepository.findAllByProductName(productName);
    }

    public List<Product> getProductByCategoryName(String categoryName){
        return productRepository.findAllByCategory_CategoryName(categoryName);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product modifyProduct(long id,Product product){
        getProductById(id);
        product.setId(id);
        return productRepository.save(product);
    }

    public Map<String,String> deleteProduct(long id){
        getProductById(id);
        productRepository.deleteById(id);
        return Map.of("Message","Successfully Deleted product with id : "+id);
    }


}
