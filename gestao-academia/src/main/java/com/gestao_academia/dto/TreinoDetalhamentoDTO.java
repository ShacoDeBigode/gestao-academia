package com.gestao_academia.dto;
import com.gestao_academia.model.Treino;
import java.time.LocalDate;
import java.util.UUID;


public record TreinoDetalhamentoDTO(
        UUID id,
        String nome,
        LocalDate dataCriacao,
        String nomeAluno
) {
    public TreinoDetalhamentoDTO(Treino treino){
        this(
                treino.getId(),
                treino.getNome(),
                treino.getDataCriacao(),
                treino.getAluno() != null ? treino.getAluno().getNome() : "Sem Aluno"
        );
    }


}
