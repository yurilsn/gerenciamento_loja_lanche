package com.gerenciamento.loja.gerenciamento_loja.service.security;

import com.gerenciamento.loja.gerenciamento_loja.repository.UsuarioRepository;
import com.gerenciamento.loja.gerenciamento_loja.security.UsuarioAutenticado;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByNome(username).map(
                usuario -> new UsuarioAutenticado(usuario)
        ).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    }
}
