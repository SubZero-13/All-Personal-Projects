import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ResultService } from '../services/result.service';

@Component({
  selector: 'app-teacher-edit',
  templateUrl: './teacher-edit.component.html',
  styleUrls: ['./teacher-edit.component.css']
})
export class TeacherEditComponent implements OnInit {
  data: any;
  editForm: any;
  rollNumber: number = 0;
  constructor(private router: Router, private service: ResultService, private route: ActivatedRoute) {
  }

  initForm() {
    this.editForm = new FormGroup({
      rollNumber: new FormControl(this.data.rollNumber),
      studentName: new FormControl(this.data.studentName),
      dateOfBirth: new FormControl(this.data.dateOfBirth),
      score: new FormControl(this.data.score),
      id: new FormControl(this.data.id)
    });
    console.log(this.editForm.value);
  }

  editStudent() {
    // console.log(this.editForm.value)
    // console.log(Studata)
    // this.service.getStudents(Studata.rollNumber);
    // this.service.putStudent(data).subscribe((data) => {
    // });
    if (this.editForm.value && typeof this.editForm.value === 'object') {
      this.service.putStudent(this.editForm.value).subscribe(() => {
      });
    }
    this.router.navigate(['tResult']);
  }
  goBack() {
    this.router.navigate(['tResult']);
  }
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.service.getStudent().subscribe((data) => {
        let student = data as any[];
        console.log(student);
        if (student && student.length > 0) {
          this.data = student[0];
          this.initForm();
        }

      });
    }
    )

  }

}

