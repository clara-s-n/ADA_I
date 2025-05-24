package com.hotel.reservas.controller;

import com.hotel.reservas.model.ResHabitacion;
import com.hotel.reservas.service.ResHabitacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/res-habitaciones")
public class ResHabitacionController {

    private final ResHabitacionService service;

    public ResHabitacionController(ResHabitacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<ResHabitacion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResHabitacion> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResHabitacion crear(@RequestBody ResHabitacion r) {
        return service.guardar(r);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResHabitacion> actualizar(@PathVariable Long id, @RequestBody ResHabitacion r) {
        ResHabitacion actualizado = service.actualizar(id, r);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}