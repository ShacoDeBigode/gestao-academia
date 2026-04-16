package com.gestao_academia.controller;

import com.gestao_academia.model.Perfil;
import com.gestao_academia.model.StatusPagamento;
import com.gestao_academia.repository.MensalidadeRepository;
import com.gestao_academia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stats")
public class DashboardController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getStats() {
        Map<String, Object> stats = new HashMap<>();

        long totalAlunos = usuarioRepository.countByTipo(Perfil.ALUNO);

        BigDecimal faturamentoReal = mensalidadeRepository.somarTotalPorStatus(StatusPagamento.PAGO);

        if (faturamentoReal == null) {
            faturamentoReal = BigDecimal.ZERO;
        }

        stats.put("alunosAtivos", totalAlunos);
        stats.put("faturamento", faturamentoReal);
        stats.put("checkins", 0); // Depois a gente implementa a lógica de check-in
        stats.put("metas", 100);

        return ResponseEntity.ok(stats);
    }
}