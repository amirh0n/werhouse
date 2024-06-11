package com.example.warehouse10b.Controller;

import com.example.warehouse10b.dto.WareHouseDto;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.model.WareHouse;
import com.example.warehouse10b.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WareHouseController {
    @Autowired
    WareHouseService wareHouseService;

    @GetMapping
    public List<WareHouse>getAllWarehouse(){
        return wareHouseService.getAllWareHouse();
    }

    @GetMapping("/{id}")
    public WareHouse getWarehouseById(@PathVariable Integer id){
        return wareHouseService.gatWareHouseById(id);
    }
    @PostMapping
    public Result addWareHouse(@RequestBody WareHouseDto wareHouseDto){
        return wareHouseService.addWareHouse(wareHouseDto);
    }
    @PutMapping("/{id}")
    public Result updateWareHouse(@PathVariable Integer id,@RequestBody WareHouseDto wareHouseDto){
        return wareHouseService.updateWareHouse(wareHouseDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteWareHouse(@PathVariable Integer id){
        return wareHouseService.deleteWareHouse(id);
    }
}
