package com.gestao_academia.service;
import com.gestao_academia.model.Aula;
import com.gestao_academia.model.Reserva;
import com.gestao_academia.repository.AulaRepository;
import com.gestao_academia.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private AulaRepository aulaRepository;

    @Transactional
    public Reserva reservarVaga(Reserva reserva) {

        Aula aula = aulaRepository.findById(reserva.getAula().getId())
                .orElseThrow(() -> new RuntimeException("Aula não encontrada!"));

        if (aula.getVagas() > 0) {
            aula.setVagas(aula.getVagas() - 1);
            aulaRepository.save(aula);
            return repository.save(reserva);
        } else {
            throw new RuntimeException("Aula lotada, parceiro!");
        }
    }

    @Transactional
    public void cancelarReserva(UUID reservaId) {
        Reserva reserva = repository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        Aula aula = reserva.getAula();

        aula.setVagas(aula.getVagas() + 1);
        aulaRepository.save(aula);

        repository.delete(reserva);
    }

    public List<Reserva> listarTodas() {
        return repository.findAll();
    }
}