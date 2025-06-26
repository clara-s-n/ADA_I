package com.hotel.reservas.controller;

import com.hotel.reservas.dto.*;
import com.hotel.reservas.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public UsuarioInfo login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public void register(@RequestBody NuevoUsuario nuevoUsuario) {
        authService.register(nuevoUsuario);
    }
}
