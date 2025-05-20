package com.gerenciamento.loja.gerenciamento_loja.Service;

import com.gerenciamento.loja.gerenciamento_loja.Controller.CreateUserDto;
import com.gerenciamento.loja.gerenciamento_loja.Model.User;
import com.gerenciamento.loja.gerenciamento_loja.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository ;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto){

        var entity = new User(UUID.randomUUID(), createUserDto.username(),
                createUserDto.password(), createUserDto.email(),
                Instant.now(), null );

        var userSaved = userRepository.save(entity);

        return userSaved.getId();
    }
}
