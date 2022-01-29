package com.learning.userservice.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TranRequestDto {
    private Integer userId;
    private Integer amount;

}
