package com.imedia24.demo.service;

import com.imedia24.demo.models.Category;
import com.imedia24.demo.models.Currency;
import com.imedia24.demo.models.Product;
import com.imedia24.demo.models.Rate;
import com.imedia24.demo.openFeign.CurrencyExchange;
import com.imedia24.demo.repositories.ProductRepository;
import com.imedia24.demo.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final CurrencyService currencyService;

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
        addCurrenciesAndCategory(product);
        return productRepository.save(product);
    }

    public Product modifyProduct(long id,Product product){
        getProductById(id);
        product.setId(id);
        addCurrenciesAndCategory(product);
        return productRepository.save(product);
    }

    public void addCurrenciesAndCategory(Product product){
        try{
            log.info("Looking for category with id"+product.getPermanentCategoryId());
            Category category = categoryService.getCategoryById(product.getPermanentCategoryId());
            log.info(category);
            product.setCategory(category);
            product.setRates(currencyService.setCurrenciesIntoProduct(product));
        }catch (Exception e){
            product.setRates(currencyService.setCurrenciesIntoProduct(product));
        }
    }

    public Map<String,String> deleteProduct(long id){
        getProductById(id);
        productRepository.deleteById(id);
        return Map.of("Message","Successfully Deleted product with id : "+id);
    }


}
