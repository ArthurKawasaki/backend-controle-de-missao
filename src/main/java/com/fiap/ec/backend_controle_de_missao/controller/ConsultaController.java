package com.fiap.ec.backend_controle_de_missao.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.ec.backend_controle_de_missao.model.Consulta;
import com.fiap.ec.backend_controle_de_missao.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
@CrossOrigin
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Consulta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Consulta buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Consulta criar(@RequestBody Consulta consulta) {
        return service.salvar(consulta);
    }

    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Long id, @RequestBody Consulta consulta) {
        return service.atualizar(id, consulta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/local/{localId}")
    public List<Consulta> listarPorLocal(@PathVariable Long localId) {
        return service.listarPorLocal(localId);
    }

    @GetMapping("/equipamento/{equipamentoId}")
    public List<Consulta> listarPorEquipamento(@PathVariable Long equipamentoId) {
        return service.listarPorEquipamento(equipamentoId);
    }
}