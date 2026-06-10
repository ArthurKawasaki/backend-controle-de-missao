package com.fiap.ec.backend_controle_de_missao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.ec.backend_controle_de_missao.model.Equipamento;
import com.fiap.ec.backend_controle_de_missao.repository.EquipamentoRepository;
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

    public Equipamento atualizar(Long id, Equipamento equipamentoAtualizado) {
        Equipamento equipamentoExistente = buscarPorId(id);
        equipamentoExistente.setTipoEquipamento(equipamentoAtualizado.getTipoEquipamento());
        equipamentoExistente.setLocalInstalacao(equipamentoAtualizado.getLocalInstalacao());
        equipamentoExistente.setDataInstalacao(equipamentoAtualizado.getDataInstalacao());
        equipamentoExistente.setAtivo(equipamentoAtualizado.getAtivo());
        return repository.save(equipamentoExistente);
    }

    public void deletar(Long id) {
        Equipamento equipamento = buscarPorId(id);
        repository.delete(equipamento);
    }
}
