package com.gestao_academia.repository;

import com.gestao_academia.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ExercicioRepository extends JpaRepository<Exercicio, UUID> {
}