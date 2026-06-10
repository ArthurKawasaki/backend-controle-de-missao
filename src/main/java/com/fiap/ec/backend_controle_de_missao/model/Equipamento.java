package com.fiap.ec.backend_controle_de_missao.model;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "equipamentos")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipoEquipamento;
    @Column(nullable = false)
    private String localInstalacao;
    private LocalDate dataInstalacao;
    private Boolean ativo;
    public Equipamento() {
    }
    public Equipamento(String tipoEquipamento, String localInstalacao,
                       LocalDate dataInstalacao, Boolean ativo) {
        this.tipoEquipamento = tipoEquipamento;
        this.localInstalacao = localInstalacao;
        this.dataInstalacao = dataInstalacao;
        this.ativo = ativo;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipoEquipamento() { return tipoEquipamento; }
    public String getLocalInstalacao() { return localInstalacao; }
    public LocalDate getDataInstalacao() { return dataInstalacao; }
    public Boolean getAtivo() { return ativo; }
    public void setTipoEquipamento(String tipoEquipamento) { this.tipoEquipamento = tipoEquipamento; }
    public void setLocalInstalacao(String localInstalacao) { this.localInstalacao = localInstalacao; }
    public void setDataInstalacao(LocalDate dataInstalacao) { this.dataInstalacao = dataInstalacao; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}