package com.gestao_academia.repository;
import com.gestao_academia.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface AulaRepository extends JpaRepository<Aula, UUID> {}