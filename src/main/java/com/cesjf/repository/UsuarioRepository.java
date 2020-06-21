package com.cesjf.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cesjf.dto.ConsultaUsuarioDto;
import com.cesjf.dto.RetornoLoginDto;
import com.cesjf.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("select new com.cesjf.dto.RetornoLoginDto"
			+ "(u.id,u.nome,u.sobrenome) "
			+ "from Usuario u "
			+ "where u.login = :login "
			+ "and u.senha = :senha"
		)
	RetornoLoginDto retornoLogin(String login, String senha);
	
	@Query("select new com.cesjf.dto.ConsultaUsuarioDto"
			+ "(u.id, u.nome, u.sobrenome, u.endereco, u.nascimento, u.genero)"
			+ "from Usuario u"
			+ " where u.id = :id"
		)
	ConsultaUsuarioDto consulta(Long id);

}
