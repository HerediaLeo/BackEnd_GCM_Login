package com.example.BackEnd_Gcm_Login.repository;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BackEnd_Gcm_Login.dto.ConsultaUsuarioDto;
import com.example.BackEnd_Gcm_Login.dto.RetornoLoginDto;
import com.example.BackEnd_Gcm_Login.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("select new com.example.BackEnd_Gcm_Login.dto.RetornoLoginDto"
			+ "(u.id,u.nome,u.sobrenome) "
			+ "from Usuario u "
			+ "where u.login = :login "
			+ "and u.senha = :senha"
		)
	RetornoLoginDto retornoLogin(String login, String senha);
	
	
	@Query("select new com.example.BackEnd_Gcm_Login.dto.ConsultaUsuarioDto"
			+ "(u.id, u.nome, u.sobrenome, u.endereco, u.nascimento, u.genero)"
			+ "from Usuario u"
			+ " where u.id = :id"
		)
	ConsultaUsuarioDto consulta(Long id);

}
