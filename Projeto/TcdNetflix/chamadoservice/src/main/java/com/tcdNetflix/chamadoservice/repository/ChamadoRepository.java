package com.tcdNetflix.chamadoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcdNetflix.chamadoservice.entity.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {


}
