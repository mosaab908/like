import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  homeApiUrl : string = 'http://localhost:8080/api/home/';

  constructor(private http : HttpClient) { }

  register(name_home: string, size_home: number, cost_home: number): Observable<any> {
    const homes = {name_home: name_home, size_home: size_home, cost_home: cost_home};
    return this.http.post<any>(`${this.homeApiUrl}/register`, homes);
  }

}
