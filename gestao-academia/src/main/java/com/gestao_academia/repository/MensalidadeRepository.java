package com.gestao_academia.repository;

import com.gestao_academia.model.Mensalidade;
import com.gestao_academia.model.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.List;
import java.math.BigDecimal;

public interface MensalidadeRepository extends JpaRepository<Mensalidade, UUID> {

    List<Mensalidade> findByAlunoId(UUID alunoId);

    List<Mensalidade> findByStatusNot(StatusPagamento status);


    @Query("SELECT SUM(m.valor) FROM Mensalidade m WHERE m.status = :status")
    BigDecimal somarTotalPorStatus(@Param("status") StatusPagamento status);
}