package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.OutPutDto;
import com.example.warehouse10b.model.Client;
import com.example.warehouse10b.model.OutPut;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.model.WareHouse;
import com.example.warehouse10b.repository.ClientRepository;
import com.example.warehouse10b.repository.OutPutRepository;
import com.example.warehouse10b.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutPutService {

    @Autowired
    OutPutRepository outPutRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    public List<OutPut>getallOutPut(){
        List<OutPut> outPutList = outPutRepository.findAll();
        return  outPutList;
    }


    public Result createOutPut(OutPutDto outPutDto){
        OutPut outPut = new OutPut();
        outPut.setCode(outPutDto.getCode());
        Optional<Client>optionalClient=clientRepository.findById(outPutDto.getClientId());
        Client client=optionalClient.get();

        Optional<WareHouse>optionalWareHouse=wareHouseRepository.findById(outPutDto.getWarehouseId());
        WareHouse wareHouse=optionalWareHouse.get();
        outPut.setClient(client);
        outPut.setWareHouse(wareHouse);
        outPut.setFactureNumber(outPutDto.getFactureNumber());

        outPutRepository.save(outPut);
        return new Result(true,"Successfully");
    }

    public Result updateOutPutProduct(Integer id,OutPutDto outPutDto){
        Optional<OutPut>optionalOutPut=outPutRepository.findById(id);
        if (optionalOutPut.isPresent()) {
            OutPut outPut=optionalOutPut.get();
            outPut.setCode(outPutDto.getCode());
            outPut.setFactureNumber(outPutDto.getFactureNumber());

            Optional<Client>optionalClient=clientRepository.findById(outPutDto.getClientId());
            Client client=optionalClient.get();

            Optional<WareHouse>wareHouse=wareHouseRepository.findById(outPutDto.getWarehouseId());
            WareHouse wareHouse1=wareHouse.get();

            outPut.setClient(client);
            outPut.setWareHouse(wareHouse1);
            outPutRepository.save(outPut);
            return new Result(true,"Updated");
        }

        return new Result(false,"Not found");
    }


    public Result deleteOutPut(Integer id){
        outPutRepository.deleteById(id);
        return new Result(true,"Deleted");
    }





}
