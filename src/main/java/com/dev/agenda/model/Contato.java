package com.dev.agenda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
}
