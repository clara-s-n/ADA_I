import { Routes } from '@angular/router';
import { CategoriaListComponent } from './components/categoria-list/categoria-list.component.js';
import { CategoriaDetailComponent } from './components/categoria-detail.component/categoria-detail.component.js';
import { CategoriaFormComponent } from './components/categoria-form.component/categoria-form.component.js';

export const routes: Routes = [
  { path: '', redirectTo: 'categorias', pathMatch: 'full' },
  { path: 'categorias', component: CategoriaListComponent },
  { path: 'categorias/nueva', component: CategoriaFormComponent },
  { path: 'categorias/:id', component: CategoriaDetailComponent }
];

