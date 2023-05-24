import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, map, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResultService {
  url = "http://localhost:3000/";
  searchRollNumber: string = '';
  editRollnumber: string = '';
  constructor(private http: HttpClient) { }
  getStudents() {
    return this.http.get(this.url + "students");
  }

  getStudent() {
    return this.http.get(`${this.url}students?rollNumber=${this.editRollnumber}`);
  }

  postStudent(data: any) {
    return this.http.post(this.url + "students", data);
  }

  putStudent(student: any) {
    let id = student.id;
    console.log(id)
    console.log(student)
    return this.http.put(`${this.url}students/${id}`, student);
  }

  deleteStudent(id: number) {
    return this.http.delete(`${this.url}students/${id}`);
  }

  getStudentByRollNumberAndName(rollNumber: number, name: string): Observable<boolean> {
    return this.http.get<any[]>(`${this.url}students?rollNumber=${rollNumber}&name=${name}`)
      .pipe(
        map((data: any[]) => {
          return data.length > 0;
        }),
        catchError(() => {
          console.error('An error occurred while fetching student data.');
          return of(false);
        })
      );
  }

  getstudentSearch(value: number) {
    return this.http.get(`${this.url}students?rollNumber=${value}`);
  }
}

