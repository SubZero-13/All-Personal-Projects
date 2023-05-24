import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class TeacherAuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) { }

  canActivate(): Observable<boolean> | Promise<boolean> | boolean {
    return this.authService.isTeacherLoggedIn$.pipe(
      tap((isLoggedIn: any) => {
        if (!isLoggedIn) {
          this.router.navigate(['tLogin']);
        }
      })
    );
  }
  
}
