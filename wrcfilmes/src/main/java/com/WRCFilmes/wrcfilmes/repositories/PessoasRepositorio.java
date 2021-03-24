package com.WRCFilmes.wrcfilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WRCFilmes.wrcfilmes.models.Pessoa;

@Repository
public interface PessoasRepositorio extends JpaRepository<Pessoa, Integer> {

}
