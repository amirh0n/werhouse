package com.example.warehouse10b.Controller;

import com.example.warehouse10b.dto.ProductDto;
import com.example.warehouse10b.model.Product;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")

    public List<Product>getProduct() {
        List<Product> allProduct = productService.getAllProduct();
        return allProduct;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public Product getIDProduct(@PathVariable Integer id){
        Product productById=productService.getProductById(id);
        return  productById;
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Result create(@RequestBody ProductDto productDto){
        Result result=productService.addProduct(productDto);
        return result;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Result update(@PathVariable Integer id,@RequestBody ProductDto productDto){
        Result result=productService.updateProduct(id,productDto);
        return  result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result=productService.deleteProduct(id);
        return result;
    }
}
