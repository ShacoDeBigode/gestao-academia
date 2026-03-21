package com.gestao_academia.service;

import com.gestao_academia.model.Treino;
import com.gestao_academia.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TreinoService {
    @Autowired
    private TreinoRepository repository;

    public Treino salvar(Treino treino) {
        return repository.save(treino);
    }

    public List<Treino> listarTodos() {
        return repository.findAll();
    }
}