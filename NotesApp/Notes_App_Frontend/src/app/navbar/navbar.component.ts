import { ChangeDetectionStrategy, Component } from '@angular/core';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class NavbarComponent {
 
  constructor(public service: ServicesService, private router: Router) {}

  ngOnInit(): void {
    
  }

  refreshCurrentRoute() {
    const currentUrl = this.router.url; // Get the current URL
    this.router
      .navigateByUrl('/refresh', { skipLocationChange: true })
      .then(() => {
        this.router.navigate([currentUrl]);
      });
  }

  // Method to log out the user and navigate to the home page
  logout() {
    this.service.logout();
    this.router.navigate(['home']);
  }

  // Method to get the current user
  get currentUser() {
    return this.service.getUser();
  }
}
