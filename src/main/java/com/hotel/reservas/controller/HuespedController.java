package com.hotel.reservas.controller;

import com.hotel.reservas.dto.HuespedRequest;
import com.hotel.reservas.model.Huesped;
import com.hotel.reservas.model.Persona;
import com.hotel.reservas.service.HuespedService;
import com.hotel.reservas.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/huespedes")
public class HuespedController {

    private final HuespedService huespedService;
    private final PersonaService personaService;

    public HuespedController(HuespedService huespedService, PersonaService personaService) {
        this.huespedService = huespedService;
        this.personaService = personaService;
    }

    @GetMapping
    public List<Huesped> listar() {
        return huespedService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Huesped> obtener(@PathVariable Long id) {
        return huespedService.obtenerPorId(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Huesped crear(@RequestBody HuespedRequest dto) {
        Persona persona = personaService.obtenerPorId(dto.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Huesped h = new Huesped();
        h.setCi(dto.getCi());
        h.setNombre(dto.getNombre());
        h.setApellido(dto.getApellido());
        h.setPersona(persona);

        return huespedService.guardar(h);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Huesped> actualizar(@PathVariable Long id, @RequestBody HuespedRequest dto) {
        Persona persona = personaService.obtenerPorId(dto.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Huesped h = new Huesped();
        h.setCi(dto.getCi());
        h.setNombre(dto.getNombre());
        h.setApellido(dto.getApellido());
        h.setPersona(persona);

        Huesped actualizado = huespedService.actualizar(id, h);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        huespedService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}