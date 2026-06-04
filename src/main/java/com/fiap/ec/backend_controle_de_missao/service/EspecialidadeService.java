package com.fiap.ec.backend_controle_de_missao.service;

import com.fiap.ec.backend_controle_de_missao.model.Especialidade;
import com.fiap.ec.backend_controle_de_missao.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EspecialidadeService {
    private final EspecialidadeRepository repository;
    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }
    public Especialidade salvar(Especialidade especialidade) {
        return repository.save(especialidade);
    }
    public List<Especialidade> listar() {
        return repository.findAll();
    }
}