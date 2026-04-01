package com.gestao_academia.dto;

import com.gestao_academia.model.CheckIn;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.UUID;

public record CheckInDetalhamentoDTO (
        UUID id,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime dataCheckin,
        String tipo,
        String nomeAluno
) {
    public CheckInDetalhamentoDTO(CheckIn c) {
        this(c.getId(), c.getDataCheckin(), c.getTipo(),
                c.getAluno() != null ? c.getAluno().getNome() : "Desconhecido");
    }
}