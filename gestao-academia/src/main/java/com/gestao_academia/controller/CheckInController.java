package com.gestao_academia.controller;
import com.gestao_academia.model.CheckIn;
import com.gestao_academia.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api/checkins")
public class CheckInController {
    @Autowired
    private CheckInService service;

    @PostMapping
    public CheckIn fazerCheckIn(@RequestBody CheckIn checkIn){
        return service.registrar(checkIn);
    }
    @GetMapping
    public List<CheckIn> listar(){
        return service.listarTodos();
    }
}
