package com.hotel.reservas.controller;

import com.hotel.reservas.model.ResSala;
import com.hotel.reservas.service.ResSalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/res-salas")
public class ResSalaController {

    private final ResSalaService service;

    public ResSalaController(ResSalaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ResSala> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResSala> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResSala crear(@RequestBody ResSala r) {
        return service.guardar(r);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResSala> actualizar(@PathVariable Long id, @RequestBody ResSala r) {
        ResSala actualizado = service.actualizar(id, r);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}