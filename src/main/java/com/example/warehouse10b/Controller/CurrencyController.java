package com.example.warehouse10b.Controller;
import com.example.warehouse10b.dto.CurrencyDto;
import com.example.warehouse10b.model.Currency;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping()
    public List<Currency>getAllCurrency(){
        List<Currency> list=currencyService.getAllCurrency();
        return list;
    }

    @PostMapping()
    public Result add(@RequestBody CurrencyDto currencyDto){
        Result result=currencyService.createCurrency(currencyDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody CurrencyDto currencyDto){
        Result result=currencyService.update(id,currencyDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id){
        Result result=currencyService.deleted(id);
        return result;
    }





}
