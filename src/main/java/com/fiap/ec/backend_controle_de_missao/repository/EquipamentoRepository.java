package com.fiap.ec.backend_controle_de_missao.repository;

import com.fiap.ec.backend_controle_de_missao.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
