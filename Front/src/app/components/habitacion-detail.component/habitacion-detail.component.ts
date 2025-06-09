import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HabitacionService, Habitacion } from '../../services/habitacion';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'habitacion-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './habitacion-detail.component.html',
})
export class HabitacionDetailComponent implements OnInit {
  habitacion: Habitacion | null = null;

  constructor(
    private route: ActivatedRoute,
    private habitacionService: HabitacionService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.habitacionService.getHabitacion(id).subscribe(data => {
      this.habitacion = data;
    });
  }
}
