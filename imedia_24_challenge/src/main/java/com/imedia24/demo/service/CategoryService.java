package com.imedia24.demo.service;


import com.imedia24.demo.models.Category;
import com.imedia24.demo.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getCategoryById(long id){
        return categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found")
        );
    }

    public List<Category> getCategoryByName(String name){
        return categoryRepository.findAllByCategoryName(name);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category modifyCategory(long id , Category category){
        getCategoryById(id);
        category.setId(id);
        return categoryRepository.save(category);
    }

    public Map<String, String> deleteCategory(long id){
        getCategoryById(id);
        categoryRepository.deleteById(id);
        return Map.of("Message","Successfully Deleted category with id : "+id);
    }
}
