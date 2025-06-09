import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SalaService, Sala } from '../../services/sala.js';

@Component({
  selector: 'sala-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './sala-list.component.html'
})
export class SalaListComponent implements OnInit {
  salas: Sala[] = [];

  constructor(private salaService: SalaService) {}

  ngOnInit(): void {
    this.salaService.getSalas().subscribe(data => {
      this.salas = data;
    });
  }
}
