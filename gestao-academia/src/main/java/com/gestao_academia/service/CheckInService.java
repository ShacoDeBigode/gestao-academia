package com.gestao_academia.service;
import com.gestao_academia.model.CheckIn;
import com.gestao_academia.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CheckInService {
    @Autowired
    private CheckInRepository repository;

    public CheckIn registrar(CheckIn checkIn){
        return repository.save(checkIn);
    }

    public List<CheckIn> listarTodos(){
        return repository.findAll();
    }
}
