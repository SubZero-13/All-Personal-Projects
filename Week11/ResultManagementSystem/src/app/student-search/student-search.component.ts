import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResultService } from '../services/result.service';

@Component({
  selector: 'app-student-search',
  templateUrl: './student-search.component.html',
  styleUrls: ['./student-search.component.css']
})
export class StudentSearchComponent implements OnInit {
  error: string = '';

  constructor(private router: Router, private service: ResultService) { }

  studentSearch(data: any) {
    this.service.searchRollNumber = data.rollNumber;
    const rollNumber = data.rollNumber;
    const name = data.studentName;
    this.service.getStudentByRollNumberAndName(rollNumber, name)
      .subscribe(studentExists => {
        if (studentExists) {
          // Student exists, navigate to the result page
          this.router.navigate(['result'], { queryParams: { rollNumber: rollNumber } });
        } else {
          // Student not found, display error message
          this.error = 'Student not found.';
        }
      });
  }

  clear() {
    this.error = '';
  }


  ngOnInit(): void {
  }

}
