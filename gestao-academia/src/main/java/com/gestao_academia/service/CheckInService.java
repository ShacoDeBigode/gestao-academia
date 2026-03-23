package com.gestao_academia.service;

import com.gestao_academia.model.CheckIn;
import com.gestao_academia.model.Mensalidade;
import com.gestao_academia.model.StatusPagamento;
import com.gestao_academia.repository.CheckInRepository;
import com.gestao_academia.repository.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckInService {

    @Autowired
    private CheckInRepository repository;

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    public CheckIn registrar(CheckIn checkIn) {

        List<Mensalidade> mensalidades = mensalidadeRepository.findByAlunoId(checkIn.getAluno().getId());


        boolean temDivida = mensalidades.stream()
                .anyMatch(m -> m.getStatus() == StatusPagamento.PENDENTE);

        if (temDivida) {
            throw new RuntimeException("Acesso negado! Aluno com mensalidade pendente.");
        }


        checkIn.setDataCheckin(LocalDateTime.now());
        return repository.save(checkIn);
    }

    public List<CheckIn> listarTodos() {
        return repository.findAll();
    }
}