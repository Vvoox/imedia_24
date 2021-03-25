package com.imedia24.demo.controller;

import com.imedia24.demo.models.Product;
import com.imedia24.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Api(description = "Products APIs")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Product by id")
    public Product getProduct(@PathVariable long id){
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get All Products")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/name/{product}")
    @ApiOperation(value = "Get Product by name")
    public List<Product> getProductsByName(@PathVariable String product){
        return productService.getProductsByName(product);
    }

    @GetMapping("/category/{category}")
    @ApiOperation(value = "Get Product by Category")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return productService.getProductByCategoryName(category);
    }

    @PostMapping()
    @ApiOperation(value = "Add Product")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}/modify")
    @ApiOperation(value = "Modify Product")
    public Product modifyProduct(@PathVariable long id,@RequestBody Product product){
        return productService.modifyProduct(id,product);
    }

    @DeleteMapping("/{id}/delete")
    @ApiOperation(value = "Delete Product")
    public Map<String,String> deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }
}
