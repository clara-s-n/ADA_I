import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router'; // 👈 IMPORTANTE
import { HabitacionService, Habitacion } from '../../services/habitacion.js';
import { Router } from '@angular/router';

@Component({
  selector: 'habitacion-list',
  standalone: true,
  imports: [CommonModule, RouterModule], // 👈 AGREGADO RouterModule
  templateUrl: './habitacion-list.component.html',
})
export class HabitacionListComponent implements OnInit {
  habitaciones: Habitacion[] = [];

  constructor(private habitacionService: HabitacionService) {}

  ngOnInit(): void {
    this.habitacionService.getHabitaciones().subscribe({
      next: (data) => (this.habitaciones = data),
      error: (err) => console.error('Error cargando habitaciones', err),
    });
  }
}
