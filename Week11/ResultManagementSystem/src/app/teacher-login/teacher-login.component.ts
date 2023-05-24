import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TeacherLoginService } from '../services/teacher-login.service';
import { BehaviorSubject } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-teacher-login',
  templateUrl: './teacher-login.component.html',
  styleUrls: ['./teacher-login.component.css']
})
export class TeacherLoginComponent implements OnInit {

  isTeacherLoggedIn = new BehaviorSubject<boolean>(false)

  cacheData : any;
  loginError:string = '';
  passwordVisible = false;
  constructor(private login : TeacherLoginService, private router : Router, private authService: AuthService) { }
  loginTeacher(data : any) {
    this.login.getUser(data.email).subscribe((returnData) => {
      console.log(returnData)
      this.cacheData = returnData as any[];
      console.log(this.cacheData);
      if (this.cacheData?.length) {
        if(this.cacheData[0].email === data.email && this.cacheData[0].password === data.password) {
          this.authService.login();
          this.router.navigate(['tResult'])
        }
        else {
          this.loginError = 'Username and Password is Incorrect';
        }
      }
      else {
        this.loginError = 'Username and Password is Incorrect';
      }
      
    });
  }



  togglePasswordVisibility(): void {
    this.passwordVisible = !this.passwordVisible;
  }
  ngOnInit(): void {
  }

}
