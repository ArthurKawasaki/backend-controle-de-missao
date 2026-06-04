package com.fiap.ec.backend_controle_de_missao.service;

import com.fiap.ec.backend_controle_de_missao.model.Equipamento;
import com.fiap.ec.backend_controle_de_missao.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EquipamentoService {
    private final EquipamentoRepository repository;
    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }
    public Equipamento salvar(Equipamento equipamento) {
        return repository.save(equipamento);
    }
    public List<Equipamento> listar() {
        return repository.findAll();
    }
    public Equipamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }
}
