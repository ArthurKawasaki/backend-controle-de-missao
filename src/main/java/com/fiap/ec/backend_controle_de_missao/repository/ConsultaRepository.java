package com.fiap.ec.backend_controle_de_missao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.ec.backend_controle_de_missao.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByLocalId(Long localId);
    List<Consulta> findByEquipamentoId(Long equipamentoId);
}