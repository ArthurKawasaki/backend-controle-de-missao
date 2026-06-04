package com.fiap.ec.backend_controle_de_missao.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "equipamentos")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipoEquipamento;
    private String local;
    private String situacao;
    private String valor;
    private LocalDate dataEvento;
    private LocalTime horaEvento;
    private Boolean ativo;
    public Equipamento() {
    }
    public Equipamento(String tipoEquipamento, String local, String situacao,
                    String valor, LocalDate dataEvento, LocalTime horaEvento, Boolean ativo) {
        this.tipoEquipamento = tipoEquipamento;
        this.local = local;
        this.situacao = situacao;
        this.valor = valor;
        this.dataEvento = dataEvento;
        this.horaEvento = horaEvento;
        this.ativo = ativo;
    }
    public Long getId() { return id; }
    public String getTipoEquipamento() { return tipoEquipamento; }
    public String getLocal() { return local; }
    public String getSituacao() { return situacao; }
    public String getValor() { return valor; }
    public LocalDate getDataEvento() { return dataEvento; }
    public LocalTime getHoraEvento() { return horaEvento; }
    public Boolean getAtivo() { return ativo; }

    public void setTipoEquipamento(String tipoEquipamento) { this.tipoEquipamento = tipoEquipamento; }
    public void setLocal(String local) { this.local = local; }
    public void setSituacao(String situacao) { this.situacao = situacao; }
    public void setValor(String valor) { this.valor = valor; }
    public void setDataEvento(LocalDate dataEvento) { this.dataEvento = dataEvento; }
    public void setHoraEvento(LocalTime horaEvento) { this.horaEvento = horaEvento; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}