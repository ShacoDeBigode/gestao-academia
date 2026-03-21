package com.gestao_academia.service;

import com.gestao_academia.model.Aluno;
import com.gestao_academia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Aluno buscarPorId(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}