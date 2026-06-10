package com.fiap.ec.backend_controle_de_missao.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "local_id", nullable = false)
    private Local local;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private Equipamento equipamento;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String status;

    private Double valor;

    private String observacoes;

    public Consulta() {}

    public Consulta(Local local, Equipamento equipamento, LocalDateTime dataHora,
                    String status, Double valor, String observacoes) {
        this.local = local;
        this.equipamento = equipamento;
        this.dataHora = dataHora;
        this.status = status;
        this.valor = valor;
    }
    public Long getId() { return id; }
    public Local getLocal() { return local; }
    public Equipamento getEquipamento() { return equipamento; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getStatus() { return status; }
    public Double getValor() { return valor; }
    public String getObservacoes() { return observacoes; }

    public void setId(Long id) { this.id = id; }
    public void setLocal(Local local) { this.local = local; }
    public void setEquipamento(Equipamento equipamento) { this.equipamento = equipamento; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public void setStatus(String status) { this.status = status; }
    public void setValor(Double valor) { this.valor = valor; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

}

