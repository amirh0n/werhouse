package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.WareHouseDto;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.model.WareHouse;
import com.example.warehouse10b.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WareHouseService {

    @Autowired
    WareHouseRepository wareHouseRepository;

    public List<WareHouse> getAllWareHouse(){
        return wareHouseRepository.findAll();
    }

    public WareHouse gatWareHouseById(Integer id){
        Optional<WareHouse> wareHouseOptional=wareHouseRepository.findById(id);
        return wareHouseOptional.get();
    }

    public Result addWareHouse(WareHouseDto wareHouseDto){
        WareHouse wareHouse = new WareHouse();
        wareHouse.setName(wareHouseDto.getName());
        wareHouse.setActive(wareHouseDto.getActive());
        wareHouseRepository.save(wareHouse);
        return new Result(true,"Warehouse update successfully");
    }

    public Result updateWareHouse(WareHouseDto wareHouseDto,Integer id){
        Optional<WareHouse> wareHouseOptional=wareHouseRepository.findById(id);
        if (wareHouseOptional.isPresent()){
            WareHouse wareHouse = new WareHouse();
            wareHouse.setName(wareHouseDto.getName());
            wareHouse.setActive(wareHouseDto.getActive());
            wareHouseRepository.save(wareHouse);
            return new Result(true,"Warehouse update successfully");
        }
        return new Result(false,"Warehouse not found");
    }

    public Result deleteWareHouse(Integer id){
        wareHouseRepository.deleteById(id);
        return new Result(true,"Warehouse deleted");
    }




}
