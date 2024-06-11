package com.example.warehouse10b.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OutPut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Timestamp date;
    @ManyToOne
    private WareHouse wareHouse;
    @Column(nullable = false)
    private String factureNumber;
    @Column(nullable = false)
    private String code;
    @ManyToOne
    private Client client;
}
