import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TeacherLoginService {
  constructor(private http: HttpClient) { }
  getUser(id: string) {
    return this.http.get(`http://localhost:3000/user?email=${id}`);
  }
}
