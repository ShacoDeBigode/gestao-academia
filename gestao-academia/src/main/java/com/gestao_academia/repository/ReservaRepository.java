package com.gestao_academia.repository;
import com.gestao_academia.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface ReservaRepository extends JpaRepository<Reserva, UUID> {}