import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { ServicesService } from '../services.service';

@Injectable({
  providedIn: 'root',
})
export class authGuard implements CanActivate {
  constructor(private authService: ServicesService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isLogIn()) {
      // User is logged in, allow access
      return true;
    } else {
      // User is not logged in, redirect to login page
      this.router.navigate(['/login']);
      return false;
    }
  }
}

