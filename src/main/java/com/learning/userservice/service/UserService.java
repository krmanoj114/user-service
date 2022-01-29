package com.learning.userservice.service;

import com.learning.userservice.dto.UserDto;
import com.learning.userservice.entity.User;
import com.learning.userservice.repository.UserRepository;
import com.learning.userservice.util.EntityUtilDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public Flux<UserDto> all(){
        return this.userRepository.findAll()
                .map(EntityUtilDto::toDto);
    }

    public Mono<UserDto> findById(final int userId){
        return this.userRepository.findById(userId)
                .map(EntityUtilDto::toDto);
    }

    public Mono<UserDto> createUser(Mono<UserDto> userDtoMono){
        return userDtoMono.map(EntityUtilDto::toEntity)
                .flatMap(e ->this.userRepository.save(e))
                .map(EntityUtilDto::toDto);
    }

    public Mono<UserDto> updateUser(int userId, Mono<UserDto> userDtoMono){
        return this.userRepository.findById(userId)
                .flatMap(user -> userDtoMono
                                .map(EntityUtilDto::toEntity)
                                .doOnNext(e->e.setId(userId)))
                .flatMap(this.userRepository::save)
                .map(EntityUtilDto::toDto);
    }

    public Mono<Void> deleteUser(int id){
        return this.userRepository.deleteById(id);
    }


}
