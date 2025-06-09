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
    usuarioId: null,
    huespedId: null,
    empresaId: null,
    fechaIngreso: '',
    fechaSalida: ''
  };

  constructor(
    private reservaService: ReservaService,
    private router: Router
  ) {}

crearReserva() {
  console.log('Enviando reserva:', this.reserva);
  this.reservaService.createReserva(this.reserva).subscribe({
    next: () => {
      alert('Reserva creada correctamente');
    },
    error: (err: any) => console.error('Error al crear reserva', err)
  });
}

}
