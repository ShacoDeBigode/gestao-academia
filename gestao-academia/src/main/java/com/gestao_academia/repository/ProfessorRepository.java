package com.gestao_academia.repository;

import com.gestao_academia.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
}