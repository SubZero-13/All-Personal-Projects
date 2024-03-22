import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  user = new User();
  constructor(private service: ServicesService, private router: Router,  private toastr: ToastrService) {}
  ngOnInit(): void {}

  // Method to register a new user
  registerUser() {
    this.service.registerUser(this.user).subscribe({
      next: (data) => {
        this.toastr.success('Your Notes Oasis Is Just a Login Away', 'Congratulations! 📌', {
          timeOut: 3000,
        });
        // this.registrationSuccessful = true;
        this.service.setUser(data);
        this.service.isLoggedIn = true;
        this.router.navigate(['login'], { queryParams: { registered: true } });
      },
      error: (err) => {
        console.log(err.error);
        this.toastr.error(err.error, 'Failed', {
          timeOut: 3000,
        });
      },
    });
  }
}
