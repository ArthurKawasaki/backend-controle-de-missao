package com.fiap.ec.backend_controle_de_missao.controller;

import com.fiap.ec.backend_controle_de_missao.model.Equipamento;
import com.fiap.ec.backend_controle_de_missao.service.EquipamentoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/equipamento")
@CrossOrigin
public class EquipamentoController {
    private final EquipamentoService service;
    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }
    @PostMapping
    public Equipamento criar(@RequestBody Equipamento equipamento) {
        return service.salvar(equipamento);
    }
    @GetMapping
    public List<Equipamento> listar() {
        return service.listar();
    }
    @GetMapping("/{id}")
    public Equipamento buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}