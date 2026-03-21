package com.gestao_academia.controller;
import com.gestao_academia.model.Aula;
import com.gestao_academia.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @PostMapping
    public Aula criar(@RequestBody Aula aula){
        return repository.save(aula);
    }

    @GetMapping
    public List<Aula> listar(){
        return repository.findAll();
    }
}
