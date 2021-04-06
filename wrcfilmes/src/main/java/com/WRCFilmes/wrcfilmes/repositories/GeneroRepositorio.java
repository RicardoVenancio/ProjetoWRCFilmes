package com.WRCFilmes.wrcfilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WRCFilmes.wrcfilmes.models.Genero;


@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Integer>{

}
