package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.OutPutProductDto;
import com.example.warehouse10b.model.OutPut;
import com.example.warehouse10b.model.OutputProduct;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.repository.OutPutProductRepository;
import com.example.warehouse10b.repository.OutPutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutPutProductService {

    @Autowired
    OutPutRepository outPutRepository;

    @Autowired
    private OutPutProductRepository outPutProductRepository;

    public List<OutputProduct> getallOutPutProducts(){
        List<OutputProduct>alloutputProduct=outPutProductRepository.findAll();
        return alloutputProduct;
    }

    public OutputProduct getOutPutProductById(Integer id){
        Optional<OutputProduct> byId=outPutProductRepository.findById(id);
        return byId.get();
    }

    public Result createOutPutProduct(OutPutProductDto outPutProductDto){
        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setAmount(outPutProductDto.getAmount());
        outputProduct.setPrice(outPutProductDto.getPrice());

        Optional<OutputProduct> outPutOptional=outPutProductRepository.findById(outPutProductDto.getOutPut());
        OutPut outPut = outputProduct.getOutPut();
        outputProduct.setOutPut(outPut);
        outPutProductRepository.save(outputProduct);
        return new Result(true,"Create");
    }

    public Result editOutPutProduct(Integer id,OutPutProductDto outPutProductDto){
        Optional<OutputProduct> productOptional= outPutProductRepository.findById(id);
        if (productOptional.isPresent()){
            OutputProduct outputProduct = new OutputProduct();
            outputProduct.setAmount(outPutProductDto.getAmount());
            outputProduct.setPrice(outPutProductDto.getPrice());

            Optional<OutPut>optionalOutPut=outPutRepository.findById(outPutProductDto.getOutPut());
            OutPut outPut=optionalOutPut.get();
            outputProduct.setOutPut(outPut);
            outPutProductRepository.save(outputProduct);
            return new Result(true,"Updated");

        }
        return new Result(false,"Not found");
    }

    public Result deleteOP(Integer id){
        outPutProductRepository.deleteById(id);
        return new Result(true,"Deleted");
    }



}
