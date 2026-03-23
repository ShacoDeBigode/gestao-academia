package com.gestao_academia.controller;

import com.gestao_academia.model.Reserva;
import com.gestao_academia.service.ReservaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return service.reservarVaga(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable UUID id){
        service.cancelarReserva(id);
        return ResponseEntity.noContent().build();
    }
}

