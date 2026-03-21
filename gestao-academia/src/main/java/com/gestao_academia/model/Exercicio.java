package com.gestao_academia.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "exercicios")
@Data
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String nome;
    private String descricao;
    private String videoUrl;
}
