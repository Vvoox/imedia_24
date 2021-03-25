package com.imedia24.demo.controller;

import com.imedia24.demo.models.Category;
import com.imedia24.demo.models.Product;
import com.imedia24.demo.repositories.CategoryRepository;
import com.imedia24.demo.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Api(description = "Category APIs")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get category by id")
    public Category getCategory(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }


    @GetMapping("/all")
    @ApiOperation(value = "Get All Categories")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/name/{category}")
    @ApiOperation(value = "Get Category by name")
    public List<Category> getCategoryByName(@PathVariable String category){
        return categoryService.getCategoryByName(category);
    }

    @PostMapping
    @ApiOperation(value = "Add Category")
    public Category addCategory(@RequestBody @Valid Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}/modify")
    @ApiOperation(value = "Modify Category")
    public Category modifyCategory(@PathVariable long id,@RequestBody @Valid Category category){
        return categoryService.modifyCategory(id,category);
    }

    @DeleteMapping("/{id}/delete")
    @ApiOperation(value = "Delete Category")
    public Map<String,String> deleteCategory(@PathVariable long id){
        return categoryService.deleteCategory(id);
    }

}
