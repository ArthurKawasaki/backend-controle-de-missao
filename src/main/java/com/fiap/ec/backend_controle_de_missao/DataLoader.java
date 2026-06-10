package com.fiap.ec.backend_controle_de_missao;

import java.time.LocalDateTime;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fiap.ec.backend_controle_de_missao.model.Consulta;
import com.fiap.ec.backend_controle_de_missao.model.Local;
import com.fiap.ec.backend_controle_de_missao.model.Equipamento;
import com.fiap.ec.backend_controle_de_missao.repository.ConsultaRepository;
import com.fiap.ec.backend_controle_de_missao.repository.LocalRepository;
import com.fiap.ec.backend_controle_de_missao.repository.EquipamentoRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ConsultaRepository consultaRepository;
    private final LocalRepository localRepository;
    private final EquipamentoRepository equipamentoRepository;

    public DataLoader(ConsultaRepository consultaRepository,
                      LocalRepository localRepository,
                      EquipamentoRepository equipamentoRepository) {
        this.consultaRepository = consultaRepository;
        this.localRepository = localRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        if (consultaRepository.count() > 0) {
            System.out.println("DataLoader: consultas já existem, pulando seed.");
            return;
        }

        List<Local> locals = localRepository.findAll();
        List<Equipamento> equipamentos = equipamentoRepository.findAll();

        if (locals.isEmpty() || equipamentos.isEmpty()) {
            System.out.println("DataLoader: sem local ou equipamento para associar consultas.");
            return;
        }

        Local local1 = locals.get(0);
        Local local2 = locals.size() > 1 ? locals.get(1) : local1;
        Equipamento equipamento1 = equipamentos.get(0);
        Equipamento equipamento2 = equipamentos.size() > 1 ? equipamentos.get(1) : equipamento1;

        consultaRepository.saveAll(List.of(
                new Consulta(local1, equipamento1,
                        LocalDateTime.of(2026, 5, 20, 9, 0), "agendada", 250.00,
                        "Consulta de rotina"),
                new Consulta(local2, equipamento2,
                        LocalDateTime.of(2026, 5, 21, 14, 30), "confirmada", 350.00,
                        "Retorno pós-exame"),
                new Consulta(local1, equipamento2,
                        LocalDateTime.of(2026, 5, 15, 10, 0), "realizada", 200.00,
                        null),
                new Consulta(local2, equipamento1,
                        LocalDateTime.of(2026, 5, 18, 11, 0), "cancelada", 300.00,
                        "Paciente desmarcou")
        ));

        System.out.println("DataLoader: 4 consultas de exemplo criadas com sucesso!");
    }
}