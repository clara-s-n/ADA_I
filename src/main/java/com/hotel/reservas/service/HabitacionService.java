package com.hotel.reservas.service;

import com.hotel.reservas.model.Habitacion;
import com.hotel.reservas.repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository repo;

    public HabitacionService(HabitacionRepository repo) {
        this.repo = repo;
    }

    public List<Habitacion> listar() {
        return repo.findAll();
    }

    public Habitacion guardar(Habitacion h) {
        return repo.save(h);
    }
}
