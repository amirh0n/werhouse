package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.CurrencyDto;
import com.example.warehouse10b.model.Currency;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public List<Currency>getAllCurrency(){
        List<Currency>list=currencyRepository.findAll();
        return list;
    }


    public Result createCurrency(CurrencyDto currencyDto){
        Currency currency = new Currency();
        currency.setName(currencyDto.getName());
        currency.setActive(currencyDto.isActive());
        currencyRepository.save(currency);
        return new Result(true,"Successfully");
    }

    public Result update(Integer id,CurrencyDto currencyDto){
        Optional<Currency>currencyOptional=currencyRepository.findById(id);
        if (currencyOptional.isPresent()){
            Currency currency=currencyOptional.get();
            currency.setName(currencyDto.getName());
            currency.setActive(currencyDto.isActive());
            currencyRepository.save(currency);
            return new Result(true,"Updated");
        }
        return new Result(false,"Currency not found");
    }

    public Result deleted(Integer id){
        currencyRepository.deleteById(id);
        return new Result(true,"Deleted");
    }

}
