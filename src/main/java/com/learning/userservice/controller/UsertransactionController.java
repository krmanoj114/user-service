package com.learning.userservice.controller;

import com.learning.userservice.dto.TranRequestDto;
import com.learning.userservice.dto.TranResponseDto;
import com.learning.userservice.entity.UserTransaction;
import com.learning.userservice.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class UsertransactionController {

    @Autowired
    private UserTransactionService userTransactionService;

    @PostMapping
    public Mono<TranResponseDto> createTransaction(@RequestBody Mono<TranRequestDto> tranRequestDtoMono){
        return tranRequestDtoMono.flatMap(this.userTransactionService::createTransaction);
    }

    @GetMapping("{id}")
    public Flux<UserTransaction> getUserById(@RequestParam int userId){
        return  this.userTransactionService.getUserById(userId);

    }
}
