package com.example.warehouse10b.Controller;

import com.example.warehouse10b.dto.AttachmentDto;
import com.example.warehouse10b.model.Attachment;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @GetMapping()
    public List<Attachment> getAllAtt(){
        List<Attachment> list = attachmentService.getAllAttachments();
        return list;
    }

    @PostMapping()
    public Result create(@RequestBody AttachmentDto attachmentDto){
        Result result=attachmentService.createAttachment(attachmentDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody AttachmentDto attachmentDto){
        Result result=attachmentService.editAttachment(id,attachmentDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result deleted=attachmentService.deleted(id);
        return deleted;
    }

}
