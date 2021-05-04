package com.WRCFilmes.wrcfilmes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.WRCFilmes.wrcfilmes.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
