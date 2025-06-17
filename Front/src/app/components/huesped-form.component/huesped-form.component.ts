import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HuespedService, Huesped } from '../../services/huesped.js';

@Component({
  selector: 'huesped-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './huesped-form.component.html',
})
export class HuespedFormComponent {
  modelo: Huesped = { ci: '', nombre: '', apellido: '' };

  constructor(private srv: HuespedService, private router: Router) {}

  guardar() {
    this.srv.create(this.modelo).subscribe(() => this.router.navigate(['/huespedes']));
  }
}
