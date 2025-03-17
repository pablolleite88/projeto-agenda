package com.dev.agenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.agenda.model.Contato;
import com.dev.agenda.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService service;

    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Contato> criarContato(@RequestBody Contato contato) {
        return ResponseEntity.ok(service.criarContato(contato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Contato> atualizado = service.atualizarContato(id, contato);
        return atualizado.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirContato(@PathVariable Long id) {
        service.excluirContato(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarContatos() {
    return ResponseEntity.ok(service.listarContatos());
    }
}