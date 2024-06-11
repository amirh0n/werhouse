package com.example.warehouse10b.Controller;

import com.example.warehouse10b.dto.OutPutDto;
import com.example.warehouse10b.model.OutPut;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.service.OutPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutPutController {

    @Autowired
    OutPutService outPutService;

    @GetMapping()
    public List<OutPut>getAllOutPut(){
        List<OutPut>list=outPutService.getallOutPut();
        return list;
    }


    @PostMapping()
    public Result add(@RequestBody OutPutDto outPutDto){
        Result result=outPutService.createOutPut(outPutDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody OutPutDto outPutDto){
        Result result=outPutService.updateOutPutProduct(id,outPutDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result=outPutService.deleteOutPut(id);
        return result;
    }

}
