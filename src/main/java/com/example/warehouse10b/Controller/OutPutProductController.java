package com.example.warehouse10b.Controller;

import com.example.warehouse10b.dto.OutPutProductDto;
import com.example.warehouse10b.model.OutputProduct;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.service.OutPutProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/outputproduct")
public class OutPutProductController {

    @Autowired
    OutPutProductService outPutProductService;

    @GetMapping()
    public List<OutputProduct> getAllPro(){
        List<OutputProduct> outputProducts =outPutProductService.getallOutPutProducts();
        return outputProducts;
    }


    @GetMapping("/{id}")
    public OutputProduct getByIdProduct(@PathVariable Integer id){
        OutputProduct outputProduct=outPutProductService.getOutPutProductById(id);
        return outputProduct;
    }

    @PostMapping()
    public Result create(@RequestBody OutPutProductDto outPutProductDto){
        return outPutProductService.createOutPutProduct(outPutProductDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody OutPutProductDto outPutProductDto){
        return outPutProductService.editOutPutProduct(id, outPutProductDto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result=outPutProductService.deleteOP(id);
        return result;
    }

}
