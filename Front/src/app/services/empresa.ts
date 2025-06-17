import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Empresa {
  id?: number;
  rut: string;
  nomFantasia: string;
  razonSocial: string;
  persona?: {
    telefono: string;
    email: string;
    direccion: {
      pais: string;
      departamento: string;
      ciudad: string;
      calle: string;
      numPuerta: string;
    }
  }
}


@Injectable({ providedIn: 'root' })
export class EmpresaService {
  private api = 'http://localhost:8080/api/empresas';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(this.api);
  }

  getById(id: number): Observable<Empresa> {
    return this.http.get<Empresa>(`${this.api}/${id}`);
  }

  getByRut(rut: string): Observable<Empresa> {
    return this.http.get<Empresa>(`${this.api}/rut/${rut}`);
  }

  create(e: Empresa): Observable<Empresa> {
    return this.http.post<Empresa>(this.api, e);
  }
}
