package com.fiap.ec.backend_controle_de_missao.repository;

import com.fiap.ec.backend_controle_de_missao.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local, Long> {
}