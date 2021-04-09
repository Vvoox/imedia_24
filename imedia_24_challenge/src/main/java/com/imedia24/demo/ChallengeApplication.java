package com.imedia24.demo;

import com.imedia24.demo.models.Category;
import com.imedia24.demo.models.Product;
import com.imedia24.demo.repositories.CategoryRepository;
import com.imedia24.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
public class ChallengeApplication  implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }


    /***
     * Just for test
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Category category = Category
                .builder()
                .categoryName("Category 1")
                .categoryType("Clothes")
                .build();

        Category category1 = Category
                .builder()
                .categoryName("Category 1")
                .categoryType("Clothes")
                .build();

        categoryRepository.save(category);
        categoryRepository.save(category1);

        Product product = Product
                .builder()
                .category(category)
                .productName("Product 1")
                .price(1500.00)
                .build();

        Product product1 = Product
                .builder()
                .category(category)
                .productName("Product 2")
                .price(2330.00)
                .build();

        productRepository.save(product);
        productRepository.save(product1);
    }
}
