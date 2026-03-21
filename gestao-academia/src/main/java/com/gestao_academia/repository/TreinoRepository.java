package com.gestao_academia.repository;

import com.gestao_academia.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TreinoRepository extends JpaRepository<Treino, UUID> {
}