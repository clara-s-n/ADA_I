package com.hotel.reservas.controller;

import com.hotel.reservas.model.Ocupacion;
import com.hotel.reservas.service.OcupacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ocupaciones")
public class OcupacionController {
    private final OcupacionService service;

    public OcupacionController(OcupacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ocupacion> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Ocupacion> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ocupacion crear(@RequestBody Ocupacion r) { return service.guardar(r); }

    @PutMapping("/{id}")
    public ResponseEntity<Ocupacion> actualizar(@PathVariable Long id, @RequestBody Ocupacion r) {
        Ocupacion actualizado = service.actualizar(id, r);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}