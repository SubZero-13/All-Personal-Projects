import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private service: ServicesService, private router: Router) {}

  ngOnInit(): void {}

  loggedIn() {
    return this.service.isLogIn();
  }
}
