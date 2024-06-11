package com.example.warehouse10b.dto;

import com.example.warehouse10b.model.Client;
import com.example.warehouse10b.model.WareHouse;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OutPutDto {
    private Integer WarehouseId;
    private String factureNumber;
    private String code;
    private Integer clientId;

}
