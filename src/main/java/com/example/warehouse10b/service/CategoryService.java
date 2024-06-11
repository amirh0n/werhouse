package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.CategoryDto;
import com.example.warehouse10b.model.Category;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public List<Category>getAllCategory(){
        List<Category>list=categoryRepository.findAll();
        return list;
    }

    public Result createCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());
        categoryRepository.save(category);
        return new Result(true,"Category created");
    }

    public Result updateCategory(Integer id,CategoryDto categoryDto){
        Optional<Category>optional=categoryRepository.findById(id);
        if (optional.isPresent()){
            Category category=optional.get();
            category.setName(categoryDto.getName());
            category.setActive(categoryDto.isActive());
            categoryRepository.save(category);
            return new Result(true,"Category updated");
        }
        return new Result(false,"Not found");
    }


    public Result deleted(Integer id){
        categoryRepository.deleteById(id);
        return new Result (true,"Deleted");
    }

}
