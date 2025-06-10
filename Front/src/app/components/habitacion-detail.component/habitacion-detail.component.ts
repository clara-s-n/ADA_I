import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HabitacionService } from '../../services/habitacion.js';

@Component({
  selector: 'habitacion-detail',
  standalone: true,
  templateUrl: './habitacion-detail.component.html'
})
export class HabitacionDetailComponent implements OnInit {
  habitacion: any;

  constructor(
    private route: ActivatedRoute,
    private habitacionService: HabitacionService
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.habitacionService.getHabitacion(Number(id)).subscribe(data => {
      this.habitacion = data;
    });
  }
}
