package com.learning.userservice.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TranResponseDto {

    private Integer userId;
    private Integer amount;
    private TransactionStatus status;

}
