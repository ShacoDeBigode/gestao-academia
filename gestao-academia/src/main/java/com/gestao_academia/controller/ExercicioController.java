package com.gestao_academia.controller;
import com.gestao_academia.model.Exercicio;
import com.gestao_academia.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {
    @Autowired
    private ExercicioService service;

    @PostMapping
    public Exercicio criar(@RequestBody Exercicio exercicio){
        return service.salvar(exercicio);
    }

    @GetMapping
    public List<Exercicio> listar(){
        return service.listarTodos();
    }
}
