import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { ServicesService } from '../services.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  // msg: any;
  user = new User();

  constructor(
    private service: ServicesService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {}

  loginUser() {
    localStorage.clear();
    const loginData = {
      userName: this.user.email,
      password: this.user.password,
    };

    this.service.generateToken(loginData).subscribe({
      next: (data: any) => {
        this.service.loginUserToken(data.token);
        this.service.getCurrentUser().subscribe({
          next: (user: any) => {
            this.service.setUser(user);
            // Check if login was successful and then navigate to "viewnotes"
            if (user) {
              this.toastr.success(
                'Your Notes Awaits Your Brilliance',
                'Welcome Back!',
                {
                  timeOut: 3000,
                }
              );
              this.router.navigate(['home']);
            } else {
              // this.msg = 'Login failed. Please check your credentials.';
            }
          },
          error: (error) => {
            // console.log(error);
          },
        });
      },
      error: (error) => {
        console.log(error);
        this.toastr.error(
          ' Retry and Dive Into Notes',
          'Credentials Mismatch!',
          {
            timeOut: 5000,
          }
        );
      },
    });
  }
  loggedIn() {
    return this.service.isLogIn();
  }

  logout() {
    this.service.logout();
    this.router.navigate(['viewnotes']);
  }
}
