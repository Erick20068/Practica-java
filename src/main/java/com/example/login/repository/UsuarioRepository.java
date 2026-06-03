package com.example.login.repository;

import com.example.login.entity.Usuario;
import java.util.Optional;

public interface UsuarioRepository {

    default Optional<Usuario> findByUsername(String username) {
        if ("admin".equals(username)) {
            return Optional.of(new Usuario("admin", "12345"));
        }
        return Optional.empty();
    }
}