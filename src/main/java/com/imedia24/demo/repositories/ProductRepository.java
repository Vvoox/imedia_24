package com.imedia24.demo.repositories;

import com.imedia24.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByPrice(double price);
    List<Product> findAllByProductName(String name);
    List<Product> findAllByCategory_CategoryName(String categoryName);
}
