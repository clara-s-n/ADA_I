package com.hotel.reservas.controller;

import com.hotel.reservas.model.Sala;
import com.hotel.reservas.service.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {
    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sala> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sala crear(@RequestBody Sala r) { return service.guardar(r); }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizar(@PathVariable Long id, @RequestBody Sala r) {
        Sala actualizado = service.actualizar(id, r);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}