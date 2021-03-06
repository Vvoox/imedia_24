package com.imedia24.demo.repositories;

import com.imedia24.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;
import java.util.Optional;

@RepositoryRestController
public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAllByCategoryName(String categoryName);
    Optional<Category> findByCategoryName(String name);
    Optional<Category> findById(long id);
}
