package com.gestao_academia.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "aulas")
@Data
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private LocalDateTime dataHora;
    private int vagas;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}