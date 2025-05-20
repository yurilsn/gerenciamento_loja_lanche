package com.gerenciamento.loja.gerenciamento_loja.Controller;

import com.gerenciamento.loja.gerenciamento_loja.Model.User;
import com.gerenciamento.loja.gerenciamento_loja.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/loja/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createuser(@RequestBody CreateUserDto createUserDto){
        var userId = userService.createUser(createUserDto);

        return ResponseEntity.created(URI.create("/loja/users" + userId.toString())).build();
    }

    @GetMapping
    public ResponseEntity<User> getuser(@PathVariable("userid") String userId){
        //
        return null;
    }
}
