import { Component } from '@angular/core';
import { Review } from 'src/app/dataTypes/review';
import { User } from 'src/app/dataTypes/user';
import { ReviewService } from 'src/app/services/review.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
    reviews!: Review[];
    users!: User[];
    noOfUsers: number = 0;
    noOfReviews: number = 0;
    activeUsers: number = 0;
  response: any;

    constructor(private reviewService: ReviewService, private userService: UserService) { }


    ngOnInit() {
      this.loadReviews();
      this.loadUsers();
    }
  
    loadReviews() {
      this.reviewService.getAllReviews().subscribe(
        (response) => {
          this.reviews = response;
          this.noOfReviews = this.reviews.length;
        },
        (error: any) => {
          // console.error('Error occurred while fetching reviews:', error);
        }
      );
    }


    loadUsers() {
      this.userService.getAllUsers().subscribe(
        (response: any) => {
          this.users = response;
          this.noOfUsers = this.users.length;
          this.activeUsers = this.users.filter(user => user.userType.toLowerCase() !== 'admin').length;
        },
        (error: any) => {
          // console.error('Error occurred while fetching users:', error);
        }
      );
    }
}
