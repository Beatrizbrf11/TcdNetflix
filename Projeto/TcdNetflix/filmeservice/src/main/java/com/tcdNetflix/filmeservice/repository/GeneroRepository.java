package com.tcdNetflix.filmeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcdNetflix.filmeservice.entity.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
