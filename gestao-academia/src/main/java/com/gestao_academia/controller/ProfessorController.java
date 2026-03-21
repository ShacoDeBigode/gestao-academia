package com.gestao_academia.controller;
import com.gestao_academia.model.Professor;
import com.gestao_academia.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    public Professor criar(@RequestBody Professor professor){
        return repository.save(professor);
    }

    @GetMapping
    public List<Professor> listar(){
        return repository.findAll();
    }
}
