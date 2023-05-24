import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private isTeacherLoggedInSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public isTeacherLoggedIn$: Observable<boolean> = this.isTeacherLoggedInSubject.asObservable();

  constructor(private router: Router) { 
    const isLoggedIn = localStorage.getItem('isTeacherLoggedIn');
    if (isLoggedIn) {
      this.isTeacherLoggedInSubject.next(true);
    }
  }

  login(): void {
    this.isTeacherLoggedInSubject.next(true);
    localStorage.setItem('isTeacherLoggedIn', 'true');
  }

  logout(): void {
    this.isTeacherLoggedInSubject.next(false);
    localStorage.removeItem('isTeacherLoggedIn');
    this.router.navigate(['tLogin']);
  }
}
