import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ReservaService, Reserva } from '../../services/reserva';

@Component({
  selector: 'reserva-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './reserva-list.component.html'
})
export class ReservaListComponent implements OnInit {
  reservas: Reserva[] = [];

  constructor(private reservaService: ReservaService) {}

  ngOnInit() {
    this.reservaService.getReservas().subscribe(data => {
      this.reservas = data;
    });
  }
}
