package com.dev.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.agenda.model.Contato;
import com.dev.agenda.repository.ContatoRepository;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public Contato criarContato(Contato contato) {
        return repository.save(contato);
    }

    public Optional<Contato> atualizarContato(Long id, Contato contatoAtualizado) {
        return repository.findById(id).map(contato -> {
            contato.setNome(contatoAtualizado.getNome());
            contato.setTelefone(contatoAtualizado.getTelefone());
            contato.setEmail(contatoAtualizado.getEmail());
            return repository.save(contato);
        });
    }

    public void excluirContato(Long id) {
        repository.deleteById(id);
    }

    public List<Contato> listarContatos() {
        return repository.findAll();
    }
}