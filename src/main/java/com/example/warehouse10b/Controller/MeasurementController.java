package com.example.warehouse10b.Controller;

import com.example.warehouse10b.dto.MeasurementDto;
import com.example.warehouse10b.model.Measurement;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @GetMapping()
    public List<Measurement> measurementList(){
        List<Measurement>list=measurementService.getAllMeasurement();
        return list;
    }

    @PostMapping()
    public Result add(@RequestBody MeasurementDto measurementDto){
        Result result=measurementService.add(measurementDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody MeasurementDto measurementDto){
        Result result=measurementService.update(id,measurementDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id){
        Result result=measurementService.delete(id);
        return result;
    }
}

