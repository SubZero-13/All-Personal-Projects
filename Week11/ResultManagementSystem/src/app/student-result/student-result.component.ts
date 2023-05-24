import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ResultService } from '../services/result.service';

@Component({
  selector: 'app-student-result',
  templateUrl: './student-result.component.html',
  styleUrls: ['./student-result.component.css']
})

export class StudentResultComponent implements OnInit {
  data: any;
  rollNumber: number = 0;
  error:string = '';

  constructor(
    private router: Router,
    private service: ResultService,
    private route: ActivatedRoute
  ) {}

  goBack() {
    this.router.navigate(['search']);
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const rollNumberParam = params['rollNumber'];
      if (!rollNumberParam) {
        console.error('Roll number is not provided in the query parameters.');
        return;
      }
      const parsedRollNumber = parseInt(rollNumberParam, 10);
      if (Number.isNaN(parsedRollNumber)) {
        console.error('Invalid roll number:', rollNumberParam);
        return;
      }

      this.rollNumber = parsedRollNumber;

      this.service.getstudentSearch(this.rollNumber).subscribe((data) => {
        let student = data as any[];
        console.log(student);
        if (student && student.length > 0) {
          this.data = student[0];
        } else {
          // Handle case when student is not found
          console.log('Student not found');
          this.error = 'Student not found';
        }
      });
    });
  }
}
