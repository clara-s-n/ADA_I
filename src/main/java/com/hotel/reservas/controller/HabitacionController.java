package com.hotel.reservas.controller;

import com.hotel.reservas.model.Habitacion;
import com.hotel.reservas.service.HabitacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    private final HabitacionService service;

    public HabitacionController(HabitacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Habitacion> listar() {
        return service.listar();
    }

    @PostMapping
    public Habitacion crear(@RequestBody Habitacion h) {
        return service.guardar(h);
    }
}
