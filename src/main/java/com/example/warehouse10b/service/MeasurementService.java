package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.MeasurementDto;
import com.example.warehouse10b.model.Measurement;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;


    public List<Measurement>getAllMeasurement(){
        List<Measurement>all=measurementRepository.findAll();
        return all;
    }

    public Result add(MeasurementDto measurementDto){
        Measurement measurement = new Measurement();
        measurement.setName(measurementDto.getName());
        measurement.setActive(measurementDto.isActive());
        measurementRepository.save(measurement);
        return new Result(true,"Created");
    }

    public Result update(Integer id,MeasurementDto measurementDto){
        Optional<Measurement>optional=measurementRepository.findById(id);
        if (optional.isPresent()){
            Measurement measurement = new Measurement();
            measurement.setName(measurementDto.getName());
            measurement.setActive(measurementDto.isActive());
            measurementRepository.save(measurement);
            return new Result(true,"Update");
        }
        return new Result(false,"Not found");
    }

    public Result delete(Integer id){
        measurementRepository.deleteById(id);
        return new Result(true,"Deleted");
    }




}
