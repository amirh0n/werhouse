package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.AttachmentDto;
import com.example.warehouse10b.model.Attachment;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;


    public List<Attachment> getAllAttachments(){
        List<Attachment>attachmentList=attachmentRepository.findAll();
        return attachmentList;
    }

    public Result createAttachment(AttachmentDto attachmentDto){
        Attachment attachment = new Attachment();
        attachment.setName(attachmentDto.getName());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContentType(attachmentDto.getContentType());
        attachmentRepository.save(attachment);
        return new Result(true,"Successfully");
    }
    public Result editAttachment(Integer id,AttachmentDto attachmentDto){
        Optional<Attachment>attachmentOptional=attachmentRepository.findById(id);
        if (attachmentOptional.isPresent()){
            Attachment attachment = attachmentOptional.get();
            attachment.setName(attachmentDto.getName());
            attachment.setSize(attachmentDto.getSize());
            attachment.setContentType(attachmentDto.getContentType());
            attachmentRepository.save(attachment);
            return new Result(true,"Updated");
        }
        return new Result(false,"Not found");
    }


    public Result deleted(Integer id){
        attachmentRepository.deleteById(id);
        return new  Result(true,"Deleted");
    }

}
