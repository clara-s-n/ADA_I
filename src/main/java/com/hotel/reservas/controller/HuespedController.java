package com.hotel.reservas.controller;

import com.hotel.reservas.model.Huesped;
import com.hotel.reservas.service.HuespedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/huespedes")
public class HuespedController {
    private final HuespedService service;

    public HuespedController(HuespedService service) {
        this.service = service;
    }

    @GetMapping
    public List<Huesped> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Huesped> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Huesped crear(@RequestBody Huesped r) { return service.guardar(r); }

    @PutMapping("/{id}")
    public ResponseEntity<Huesped> actualizar(@PathVariable Long id, @RequestBody Huesped r) {
        Huesped actualizado = service.actualizar(id, r);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}