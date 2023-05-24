import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResultService } from '../services/result.service';

@Component({
  selector: 'app-teacher-add',
  templateUrl: './teacher-add.component.html',
  styleUrls: ['./teacher-add.component.css']
})
export class TeacherAddComponent implements OnInit {

  constructor(private router : Router, private service : ResultService) { }
  goToResults(){
    this.router.navigate(['tResult'])
  }
  addStudent(resData : any){
    this.service.postStudent(resData).subscribe((data)=>{
    });
    this.service.getStudents();
    this.router.navigate(['tResult']);
  }
  ngOnInit(): void {
  }

}
