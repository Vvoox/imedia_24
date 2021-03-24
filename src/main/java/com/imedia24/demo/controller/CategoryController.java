package com.imedia24.demo.controller;

import com.imedia24.demo.models.Category;
import com.imedia24.demo.models.Product;
import com.imedia24.demo.repositories.CategoryRepository;
import com.imedia24.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/all")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/name/{category}")
    public List<Category> getCategoryByName(@PathVariable String category){
        return categoryService.getCategoryByName(category);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}/modify")
    public Category modifyCategory(@PathVariable long id,@RequestBody Category category){
        return categoryService.modifyCategory(id,category);
    }

    @DeleteMapping("/{id}/delete")
    public Map<String,String> deleteCategory(@PathVariable long id){
        return categoryService.deleteCategory(id);
    }

}
