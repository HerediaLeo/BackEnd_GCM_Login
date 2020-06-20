package com.example.BackEnd_Gcm_Login.repository;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BackEnd_Gcm_Login.dto.RetornoLoginDto;
import com.example.BackEnd_Gcm_Login.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("select new com.cesjf.rs.dto.RetornoLoginDto"
			+ "(u.id,u.nome,u.sobrenome) "
			+ "from Usuario u "
			+ "where u.login = :login "
			+ "and u.senha = :senha"
		)
	RetornoLoginDto retornoLogin(String login, String senha);

}
