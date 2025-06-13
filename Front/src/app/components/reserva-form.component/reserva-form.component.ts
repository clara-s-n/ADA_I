import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReservaService } from '../../services/reserva.js';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'reserva-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reserva-form.component.html'
})
export class ReservaFormComponent {
  reserva = {
    usuarioId: 1,
    huespedId: 1,
    empresaId: null,
    fechaIngreso: '',
    fechaSalida: '',
    nombre: '',
    apellido: '',
    telefono: '',
    ci: '',
    cantidad: 1,
    metodoPago: '',
    habitacionId: null as number | null 
  };

  habitacionNumero: string | null = null;
  habitacionTipoNombre: string | null = null;

  constructor(
    private reservaService: ReservaService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.route.queryParams.subscribe(params => {
      this.reserva.habitacionId = params['habitacionId'] ? parseInt(params['habitacionId'], 10) : null;
      this.habitacionNumero = params['numHabitacion'] || null;
      this.habitacionTipoNombre = params['tipo'] || null; // 👈 NUEVO: capturamos el tipo
    });
  }

  crearReserva() {
    const body = {
      usuarioId: this.reserva.usuarioId,
      huespedId: this.reserva.huespedId,
      empresaId: this.reserva.empresaId,
      fechaIngreso: this.reserva.fechaIngreso,
      fechaSalida: this.reserva.fechaSalida,
      habitacionId: this.reserva.habitacionId
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
