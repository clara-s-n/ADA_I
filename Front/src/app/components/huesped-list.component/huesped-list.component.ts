import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HuespedService, Huesped } from '../../services/huesped.js';

@Component({
  selector: 'huesped-list',
  standalone: true,
  templateUrl: './huesped-list.component.html',
  imports: [CommonModule, RouterModule],
})
export class HuespedListComponent implements OnInit {
  huespedes: Huesped[] = [];

  constructor(private srv: HuespedService) {}

  ngOnInit() {
    this.srv.getAll().subscribe((hs) => (this.huespedes = hs));
  }
}
