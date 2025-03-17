package com.dev.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.agenda.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}