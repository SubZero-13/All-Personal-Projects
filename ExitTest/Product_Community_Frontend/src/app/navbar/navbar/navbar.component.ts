import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  isLoggedIn = false; // Set to true if a user is logged in
  isAdmin = false; // Set to true if the logged-in user is an admin
  username:string='';

  constructor(private userService: UserService, private router: Router) { 
  }


  ngOnInit() {
    this.userService.isLoggedIn$.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
      const currentUser = this.userService.getCurrentUser();
      this.username = currentUser?.firstName || '';
      if(currentUser?.userType.toLowerCase() === 'admin') {
        this.isAdmin = true;
      }
    });
    console.warn(localStorage.getItem('currentUser'));

  }

  logout() {
    this.userService.logout();
    this.isLoggedIn = false; // Set to true if a user is logged in
    this.isAdmin = false;
    this.router.navigate(['']);
  }
}
