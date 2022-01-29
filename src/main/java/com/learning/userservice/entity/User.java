package com.learning.userservice.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
public class User {
    @Id
    private int id;
    private String name;
    private int balance;

}
