import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReservaService } from '../../services/reserva.js';
import { Router } from '@angular/router';

@Component({
  selector: 'reserva-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reserva-form.component.html'
})
export class ReservaFormComponent {
  reserva = {
    usuarioId: 1, // Setealo según usuario logueado o de prueba
    huespedId: 1, // Por ahora se setea fijo, luego se puede crear desde el form
    empresaId: null, // null si es una persona física
    fechaIngreso: '',
    fechaSalida: '',
    nombre: '',
    apellido: '',
    telefono: '',
    ci: '',
    cantidad: 1,
    metodoPago: ''
  };

  constructor(
    private reservaService: ReservaService,
    private router: Router
  ) {}

  crearReserva() {
    const body = {
      usuarioId: this.reserva.usuarioId,
      huespedId: this.reserva.huespedId,
      empresaId: this.reserva.empresaId,
      fechaIngreso: this.reserva.fechaIngreso,
      fechaSalida: this.reserva.fechaSalida
    };

    console.log('Enviando reserva:', body);

    this.reservaService.createReserva(body).subscribe({
      next: () => {
        alert('Reserva creada correctamente');
        this.router.navigate(['/reservas']);
      },
      error: (err: any) => console.error('Error al crear reserva', err)
    });
  }

  cancelar() {
    this.router.navigate(['/reservas']);
  }
}
