package com.hotel.reservas.service;
import com.hotel.reservas.dto.*;
import com.hotel.reservas.model.Usuario;
import com.hotel.reservas.repository.UsuarioRepository;
import com.hotel.reservas.repository.PersonaRepository;
import com.hotel.reservas.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;
    private final RolRepository rolRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    
   public UsuarioInfo login(LoginRequest login) {
    Usuario user = usuarioRepository.findByNombreUsuario(login.getNombreUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    System.out.println("🔐 Contraseña enviada desde el frontend: " + login.getContrasenia());
    System.out.println("🔐 Contraseña en la base de datos (hash): " + user.getContrasenia());

    if (!passwordEncoder.matches(login.getContrasenia(), user.getContrasenia())) {
        System.out.println("❌ No coinciden las contraseñas");
        throw new RuntimeException("Contraseña incorrecta");
    }

    System.out.println("✅ Contraseña correcta, login exitoso");

    UsuarioInfo response = new UsuarioInfo();
    response.setId(user.getId());
    response.setNombre(user.getNombre());
    response.setApellido(user.getApellido());
    response.setNombreUsuario(user.getNombreUsuario());
    response.setRol(user.getRol().getNombre());

    return response;
    }

    public void register(NuevoUsuario request) {
        Usuario nuevo = new Usuario();
        nuevo.setCi(request.getCi());
        nuevo.setNombre(request.getNombre());
        nuevo.setApellido(request.getApellido());
        nuevo.setNombreUsuario(request.getNombreUsuario());
        nuevo.setContrasenia(passwordEncoder.encode(request.getContrasenia()));
        nuevo.setRol(rolRepository.findById(request.getIdRol()).orElseThrow());
        nuevo.setPersona(personaRepository.findById(request.getIdPersona()).orElseThrow());

        usuarioRepository.save(nuevo);
    }
}
