package com.example.warehouse10b.dto;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserDto{
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String code;
        private String password;
        private boolean active;
        private Integer wareHouseId;
    }
