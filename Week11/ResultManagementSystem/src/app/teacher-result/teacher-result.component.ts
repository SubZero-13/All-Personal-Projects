import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResultService } from '../services/result.service';
import { isEntityName } from 'typescript';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-teacher-result',
  templateUrl: './teacher-result.component.html',
  styleUrls: ['./teacher-result.component.css']
})
export class TeacherResultComponent implements OnInit {
  results: any;
  constructor(private router: Router, private service: ResultService, private authService: AuthService) {
    this.fetchData();
  }
  fetchData() {
    this.service.getStudents().subscribe((data) => {
      this.results = data;
    });
  }
  getToAdd() {
    this.router.navigate(['tAdd'])
  }
  getEditResult(data: any) {
    console.log(data);
    this.service.editRollnumber = data;
    this.router.navigate(['tEdit', { queryParams: { rollNumber: data } }])
  }
  deleteElement(data: string) {
    console.log(data)
    this.service.deleteStudent(parseInt(data)).subscribe(() => {
      this.fetchData();
    });

  }
  logout() {
    this.authService.logout();
  }

  ngOnInit(): void {
  }

}
