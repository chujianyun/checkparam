package com.chujianyun.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String message;

    public UserDTO() {
    }

    public UserDTO(String message) {
        this.message = message;
    }
}
