import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginForm } from 'src/app/dataTypes/login-form';
import { SignupForm } from 'src/app/dataTypes/sign-up-form';
import { User } from 'src/app/dataTypes/user';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  isLoginForm = false;
  loginForm!: FormGroup;
  signupForm!: FormGroup;
  loginError: string = '';
  signupError: string = '';
  constructor(private formBuilder: FormBuilder, private userService:UserService, private router: Router) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });

    this.signupForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    }, { validators: this.passwordMatchValidator });
  }

  passwordMatchValidator(formGroup: FormGroup) {
    const passwordControl = formGroup.get('password');
    const confirmPasswordControl = formGroup.get('confirmPassword');
  
    if (passwordControl && confirmPasswordControl && passwordControl.value !== confirmPasswordControl.value) {
      confirmPasswordControl.setErrors({ passwordMismatch: true });
    } else {
      confirmPasswordControl?.setErrors(null);
    }
  }
  
  

  login() {
    // Implement login logic here
    const formData: LoginForm = this.loginForm.value;
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;

      const user: User = {
        email, password,
        firstName: '',
        lastName: '',
        userType: ''
      };

      this.userService.login(user).subscribe({
        next: (response: User) => {
          console.log('Logged in:', response);
          this.userService.currentUser = response;
          if(response.userType.toLowerCase() === 'regular') {
            this.router.navigate(['/user-dashboard']);
          }
          else {
            this.router.navigate(['/admin-dashboard']);
          }
        },
        error: (error: any) => {
          this.loginError = 'Invalid email or password';
        }
      });
      
    }
  }

  signup() {
    // Implement signup logic here
    const formData: SignupForm = this.signupForm.value;
    if (this.signupForm.valid) {
      const email = this.signupForm.get('email')?.value;
      const firstName = this.signupForm.get('firstName')?.value;
      const lastName = this.signupForm.get('lastName')?.value;
      const password = this.signupForm.get('password')?.value;

      const user: User = {
        email, firstName, lastName, password,
        userType: 'Regular'
      };
      this.userService.addUser(user).subscribe({
        next: (response) => {
          // Signup successful
          console.log('Signed up:', response);
          this.userService.currentUser = response;
          this.router.navigate(['/user-dashboard']);
        },
        error: (error) => {          
          this.signupError = 'Email already exists';
        }
      });
    }
  }

  openSignUp() {
    this.isLoginForm = false;
  }

  openLogin() {
    this.isLoginForm = true;
  }

}






