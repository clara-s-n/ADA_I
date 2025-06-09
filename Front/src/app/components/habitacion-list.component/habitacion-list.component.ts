import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HabitacionService, Habitacion } from '../../services/habitacion.js';

@Component({
  selector: 'habitacion-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './habitacion-list.component.html',
  styleUrls: ['./habitacion-list.component.css']
})
export class HabitacionListComponent implements OnInit {
  habitaciones: Habitacion[] = [];

  constructor(private habitacionService: HabitacionService) {}

  ngOnInit(): void {
    this.habitacionService.getHabitaciones().subscribe(data => {
      this.habitaciones = data;
    });
  }
}
