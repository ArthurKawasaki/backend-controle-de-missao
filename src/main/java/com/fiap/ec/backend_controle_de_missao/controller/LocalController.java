package com.fiap.ec.backend_controle_de_missao.controller;


import com.fiap.ec.backend_controle_de_missao.model.Local;
import com.fiap.ec.backend_controle_de_missao.service.LocalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/locals")
@CrossOrigin
public class LocalController {
    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Local> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Local buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Local salvar(@RequestBody Local local) {
        return service.salvar(local);
    }

    @PutMapping("/{id}")
    public Local atualizar(@PathVariable Long id, @RequestBody Local local) {
        return service.atualizar(id, local);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}