package com.imedia24.demo.controller;

import com.imedia24.demo.models.Currency;
import com.imedia24.demo.models.Product;
import com.imedia24.demo.openFeign.CurrencyExchange;
import com.imedia24.demo.repositories.CategoryRepository;
import com.imedia24.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Api(description = "Products APIs")
@Log4j2
public class ProductController {

    private final ProductService productService;
    private final CurrencyExchange currency;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Product by id")
    public Product getProduct(@PathVariable long id){
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get All Products")
    public List<Product> getAllProducts(){
        log.info(currency.getCurrency());
        return productService.getAllProduct();
    }

    @GetMapping("/name")
    @ApiOperation(value = "Get Product by name")
    public List<Product> getProductsByName(@RequestParam String product){
        return productService.getProductsByName(product);
    }

        @GetMapping("/category")
    @ApiOperation(value = "Get Product by Category")
    public List<Product> getProductsByCategory(@RequestParam String category){
        return productService.getProductByCategoryName(category);
    }

    @GetMapping("/price")
    @ApiOperation(value = "Get Product by Category")
    public List<Product> getProductsByPrice(@RequestParam double price){
        return productService.getProductsByPrice(price);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add Product")
    public Product addProduct(@RequestBody @Valid Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}/modify")
    @ApiOperation(value = "Modify Product")
    public Product modifyProduct(@PathVariable long id,@RequestBody @Valid Product product){
        return productService.modifyProduct(id,product);
    }

    @DeleteMapping("/{id}/delete")
    @ApiOperation(value = "Delete Product")
    public Map<String,String> deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }
}
