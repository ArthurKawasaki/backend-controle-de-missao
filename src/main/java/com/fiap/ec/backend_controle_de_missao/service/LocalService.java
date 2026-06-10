package com.fiap.ec.backend_controle_de_missao.service;

import com.fiap.ec.backend_controle_de_missao.model.Local;
import com.fiap.ec.backend_controle_de_missao.repository.LocalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalService {

    private final LocalRepository repository;

    public LocalService(LocalRepository repository) {
        this.repository = repository;
    }

    public List<Local> listar() {
        return repository.findAll();
    }

    public Local buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));
    }

    public Local salvar(Local local) {
        return repository.save(local);
    }

    public Local atualizar(Long id, Local localAtualizado) {
        Local localExistente = buscarPorId(id);
        localExistente.setNome(localAtualizado.getNome());
        localExistente.setCodigo(localAtualizado.getCodigo());
        localExistente.setEspecialidade(localAtualizado.getEspecialidade());
        localExistente.setAtivo(localAtualizado.getAtivo());
        return repository.save(localExistente);
    }

    public void deletar(Long id) {
        Local local = buscarPorId(id);
        repository.delete(local);
    }
}