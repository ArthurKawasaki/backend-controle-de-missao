package com.fiap.ec.backend_controle_de_missao.repository;

import com.fiap.ec.backend_controle_de_missao.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}