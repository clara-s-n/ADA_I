package com.hotel.reservas.service;

import com.hotel.reservas.model.Sala;
import com.hotel.reservas.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public List<Sala> listar() {
        return repository.findAll();
    }

    public Optional<Sala> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Sala guardar(Sala s) {
        return repository.save(s);
    }

    public Sala actualizar(Long id, Sala nueva) {
        return repository.findById(id)
                .map(s -> {
                    s.setCapacidad(nueva.getCapacidad());
                    s.setEstado(nueva.getEstado());
                    s.setPrecio(nueva.getPrecio());
                    s.setEquipamiento(nueva.getEquipamiento());
                    return repository.save(s);
                }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}