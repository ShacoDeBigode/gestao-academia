package com.gestao_academia.controller;

import com.gestao_academia.model.Reserva;
import com.gestao_academia.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return service.reservarVaga(reserva);
    }
}