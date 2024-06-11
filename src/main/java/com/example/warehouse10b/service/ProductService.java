package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.ProductDto;
import com.example.warehouse10b.model.Category;
import com.example.warehouse10b.model.Product;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.repository.CategoryRepository;
import com.example.warehouse10b.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> getAllProduct(){
        List<Product>productList=productRepository.findAll();
        return productList;
    }
    public Product getProductById(Integer id){
        Optional<Product>productOptional=productRepository.findById(id);
        return productOptional.get();
    }
    public Result addProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode(productDto.getCode());
        product.setActive(productDto.isActive());

        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());

        Category category=categoryOptional.get();
        product.setCategory(category);
        productRepository.save(product);
        return new Result(true,"Product added successfully");
    }
    public Result updateProduct(Integer id,ProductDto productDto){
        Optional<Product>optionalProduct=productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product=optionalProduct.get();
            product.setName(productDto.getName());
            product.setCode(productDto.getCode());
            product.setActive(productDto.isActive());

            Optional<Category>categoryOptional=categoryRepository.findById(productDto.getCategoryId());
            Category category=categoryOptional.get();
            product.setCategory(category);
            productRepository.save(product);

            return new Result(true,"Product update");
        }
        return new Result(false,"Product not Found");
    }
    public Result deleteProduct(Integer id){
        productRepository.deleteById(id);
        return new Result(true,"Product delete");
    }

}
