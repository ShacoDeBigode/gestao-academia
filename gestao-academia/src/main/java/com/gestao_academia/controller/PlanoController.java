package com.gestao_academia.controller;
import com.gestao_academia.model.Plano;
import com.gestao_academia.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    @Autowired
    private PlanoRepository repository;


    @PostMapping
    public ResponseEntity<Plano> cadastrar(@RequestBody Plano plano) {
        return ResponseEntity.ok(repository.save(plano));
    }


    @GetMapping
    public ResponseEntity<List<Plano>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
