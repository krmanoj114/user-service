package com.learning.userservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserDto {
    private int id;
    private String name;
    private int balance;

}
