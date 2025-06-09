import { Routes } from '@angular/router';
import { CategoriaListComponent } from './components/categoria-list/categoria-list.component.js';
import { CategoriaDetailComponent } from './components/categoria-detail.component/categoria-detail.component.js';
import { CategoriaFormComponent } from './components/categoria-form.component/categoria-form.component.js';
import { ReservaListComponent } from './components/reserva-list.component/reserva-list.component.js';
import { ReservaDetailComponent } from './components/reserva-detail.component/reserva-detail.component.js';
import { ReservaFormComponent } from './components/reserva-form.component/reserva-form.component.js';
import { HabitacionListComponent } from './components/habitacion-list.component/habitacion-list.component.js';
import { HabitacionDetailComponent } from './components/habitacion-detail.component/habitacion-detail.component.js';
import { SalaDetailComponent } from './components/sala-detail.component/sala-detail.component.js';
import { SalaListComponent } from './components/sala-list.component/sala-list.component.js';
export const routes: Routes = [
  { path: '', redirectTo: 'categorias', pathMatch: 'full' },
  { path: 'categorias', component: CategoriaListComponent },
  { path: 'categorias/nueva', component: CategoriaFormComponent },
  { path: 'categorias/:id', component: CategoriaDetailComponent },
  { path: 'reservas', component: ReservaListComponent },
  { path: 'reservas/nueva', component: ReservaFormComponent },
  { path: 'reservas/:id', component: ReservaDetailComponent },
  { path: 'habitaciones', component: HabitacionListComponent },
  { path: 'habitaciones/:id', component: HabitacionDetailComponent },
  { path: 'salas', component: SalaListComponent },
  { path: 'salas/:id', component: SalaDetailComponent }
];

