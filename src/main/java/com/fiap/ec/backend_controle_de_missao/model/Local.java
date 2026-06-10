package com.fiap.ec.backend_controle_de_missao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "locals")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;
    private Boolean ativo;

    public Local() {
    }

    public Local(Long id, String nome, String codigo, Especialidade especialidade, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.especialidade = especialidade;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
