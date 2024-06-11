package com.example.warehouse10b.dto;

import com.example.warehouse10b.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private String code;
    private boolean active;
    private Integer categoryId;
}
