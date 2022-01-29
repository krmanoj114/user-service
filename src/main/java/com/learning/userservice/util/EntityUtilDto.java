package com.learning.userservice.util;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.learning.userservice.dto.TranRequestDto;
import com.learning.userservice.dto.TranResponseDto;
import com.learning.userservice.dto.TransactionStatus;
import com.learning.userservice.dto.UserDto;
import com.learning.userservice.entity.User;
import com.learning.userservice.entity.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class EntityUtilDto {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }
    public static UserTransaction toEntity(TranRequestDto tranDto){
        UserTransaction userTran = new UserTransaction();
        userTran.setUserId(tranDto.getUserId());
        userTran.setAmount(tranDto.getAmount());
        userTran.setTransactionDate(LocalDateTime.now());
        return userTran;
    }

    public static TranResponseDto toDto(TranRequestDto tranReqDto, TransactionStatus status){
        TranResponseDto tranResDto = new TranResponseDto();
        tranResDto.setUserId(tranReqDto.getUserId());
        tranResDto.setAmount(tranReqDto.getAmount());
        tranResDto.setStatus(status);
        return tranResDto;
    }
}
