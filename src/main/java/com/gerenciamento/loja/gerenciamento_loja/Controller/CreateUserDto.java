package com.gerenciamento.loja.gerenciamento_loja.Controller;

import com.gerenciamento.loja.gerenciamento_loja.Model.User;

public record CreateUserDto(String username, String password, String email) {
}
