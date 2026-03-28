package com.gestao_academia.repository;

import com.gestao_academia.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PlanoRepository extends JpaRepository<Plano, UUID> {
}