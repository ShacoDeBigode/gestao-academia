package com.gestao_academia.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;


@Entity
@Table(name = "reservas")
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String status = "CONFIRMADA";

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;
}
