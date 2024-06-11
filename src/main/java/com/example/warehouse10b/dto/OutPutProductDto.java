package com.example.warehouse10b.dto;

import com.example.warehouse10b.model.OutPut;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutPutProductDto {
    private Double amount;
    private Double price;

    private Integer outPut;
}
