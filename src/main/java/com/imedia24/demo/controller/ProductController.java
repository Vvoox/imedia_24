package com.imedia24.demo.controller;

import com.imedia24.demo.models.Product;
import com.imedia24.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/name/{product}")
    public List<Product> getProductsByName(@PathVariable String product){
        return productService.getProductsByName(product);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return productService.getProductByCategoryName(category);
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}/modify")
    public Product modifyProduct(@PathVariable long id,@RequestBody Product product){
        return productService.modifyProduct(id,product);
    }

    @DeleteMapping("/{id}/delete")
    public Map<String,String> deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }
}
