package com.learning.userservice.service;

import com.learning.userservice.dto.TranRequestDto;
import com.learning.userservice.dto.TranResponseDto;
import com.learning.userservice.dto.TransactionStatus;
import com.learning.userservice.entity.UserTransaction;
import com.learning.userservice.repository.UserRepository;
import com.learning.userservice.repository.UserTransactionRepository;
import com.learning.userservice.util.EntityUtilDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserTransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    public Mono<TranResponseDto> createTransaction(final TranRequestDto tranReqDto){
        return this.userRepository.updateUserBalance(tranReqDto.getUserId(), tranReqDto.getAmount())
                .filter(Boolean::booleanValue)
                .map(b-> EntityUtilDto.toEntity(tranReqDto))
                .flatMap(this.userTransactionRepository::save)
                .map(ut->EntityUtilDto.toDto(tranReqDto, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityUtilDto.toDto(tranReqDto, TransactionStatus.DECLINED));
    }

     public Flux<UserTransaction> getUserById(int userId){
        return  this.userTransactionRepository.findByUserId(userId);
     }

}
