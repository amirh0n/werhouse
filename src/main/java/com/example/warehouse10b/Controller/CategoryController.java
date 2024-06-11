package com.example.warehouse10b.Controller;
import com.example.warehouse10b.dto.CategoryDto;
import com.example.warehouse10b.model.Category;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping()
    public List<Category>getAllCurrency(){
        List<Category>list=categoryService.getAllCategory();
        return list;
    }

    @PostMapping()
    public Result add(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.createCategory(categoryDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        Result result=categoryService.updateCategory(id,categoryDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id){
        Result result=categoryService.deleted(id);
        return result;
    }







}
