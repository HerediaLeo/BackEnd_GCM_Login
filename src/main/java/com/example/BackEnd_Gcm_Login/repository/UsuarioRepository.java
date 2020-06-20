package com.example.BackEnd_Gcm_Login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackEnd_Gcm_Login.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
