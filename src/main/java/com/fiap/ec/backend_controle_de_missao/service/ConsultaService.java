package com.fiap.ec.backend_controle_de_missao.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.ec.backend_controle_de_missao.model.Consulta;
import com.fiap.ec.backend_controle_de_missao.model.Local;
import com.fiap.ec.backend_controle_de_missao.model.Equipamento;
import com.fiap.ec.backend_controle_de_missao.repository.ConsultaRepository;
import com.fiap.ec.backend_controle_de_missao.repository.LocalRepository;
import com.fiap.ec.backend_controle_de_missao.repository.EquipamentoRepository;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final LocalRepository localRepository;
    private final EquipamentoRepository equipamentoRepository;

    public ConsultaService(ConsultaRepository consultaRepository,
                           LocalRepository localRepository,
                           EquipamentoRepository equipamentoRepository) {
        this.consultaRepository = consultaRepository;
        this.localRepository = localRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public Consulta salvar(Consulta consulta) {
        Local local = localRepository.findById(consulta.getLocal().getId())
                .orElseThrow(() -> new RuntimeException("Locacl não encontrado"));
        Equipamento equipamento = equipamentoRepository.findById(consulta.getEquipamento().getId())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        consulta.setLocal(local);
        consulta.setEquipamento(equipamento);

        return consultaRepository.save(consulta);
    }

    public Consulta atualizar(Long id, Consulta consultaAtualizada) {
        Consulta consultaExistente = buscarPorId(id);

        if (consultaAtualizada.getDataHora() != null) {
            consultaExistente.setDataHora(consultaAtualizada.getDataHora());
        }
        if (consultaAtualizada.getStatus() != null) {
            consultaExistente.setStatus(consultaAtualizada.getStatus());
        }
        if (consultaAtualizada.getValor() != null) {
            consultaExistente.setValor(consultaAtualizada.getValor());
        }
        consultaExistente.setObservacoes(consultaAtualizada.getObservacoes());

        if (consultaAtualizada.getLocal() != null && consultaAtualizada.getLocal().getId() != null) {
            Local local = localRepository.findById(consultaAtualizada.getLocal().getId())
                    .orElseThrow(() -> new RuntimeException("Local não encontrado"));
            consultaExistente.setLocal(local);
        }
        if (consultaAtualizada.getEquipamento() != null && consultaAtualizada.getEquipamento().getId() != null) {
            Equipamento equipamento = equipamentoRepository.findById(consultaAtualizada.getEquipamento().getId())
                    .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
            consultaExistente.setEquipamento(equipamento);
        }

        return consultaRepository.save(consultaExistente);
    }

    public void deletar(Long id) {
        Consulta consulta = buscarPorId(id);
        consultaRepository.delete(consulta);
    }

    public List<Consulta> listarPorLocal(Long localId) {
        return consultaRepository.findByLocalId(localId);
    }

    public List<Consulta> listarPorEquipamento(Long equipamentoId) {
        return consultaRepository.findByEquipamentoId(equipamentoId);
    }
}
