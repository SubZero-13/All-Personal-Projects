import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Review } from '../dataTypes/review';
import { ProductService } from '../services/product.service';
import { ReviewService } from '../services/review.service';
import { UserService } from '../services/user.service';
import { User } from '../dataTypes/user';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product: any;
  approvedReviews: Review[] = [];
  description:string = '';
  rating:number = 0;

  userType:string=''

  descriptionTouched: boolean = false;
  ratingTouched: boolean = false;

  get descriptionInvalid(): boolean {
    return this.descriptionTouched && !this.description;
  }

  get ratingInvalid(): boolean {
    return this.ratingTouched && (this.rating < 0 || this.rating > 5);
  }

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private reviewService: ReviewService,
    private userService: UserService
  ) { }

  ngOnInit(): void {
    const productCode = this.route.snapshot.paramMap.get('code')!;
    console.log(productCode)
    const user = this.userService.getCurrentUser();
    if(user) {
      if(user.userType.toLowerCase() === 'admin') {
        this.userType = 'admin';
      }
    }
    this.getProductDetails(productCode);
    this.getApprovedReviews(productCode);
  }

  getProductDetails(productCode:string): void {
    // const code = this.route.snapshot.paramMap.get('code');
    this.productService.getProductByCode(productCode).subscribe(product => {
      this.product = product;
    });
  }

  getApprovedReviews(productCode:string): void {
    this.reviewService.getReviewsByProductCode(productCode).subscribe(
      (reviews) => {
        this.approvedReviews = reviews.filter((review) => review.status === 'Approved');
      },
      (error) => {
        // console.error('Error fetching approved reviews:', error);
        // Handle the error and display an error message to the user
      }
    );
  }

  addReview(): void {
    const user = this.userService.getCurrentUser();
    const newReview = {
      description: this.description,
      rating: this.rating,
      product: this.product,
      user: user!,
      status: 'Pending'
    };
    this.reviewService.addReview(newReview).subscribe(
      (_addedReview: any) => {
        // console.log(this.addReview);
      },
      (error: any) => {
        // console.error('Error adding review:', error);
      }
    );
    this.description = '';
    this.rating = 0;
  }

  goBack(): void {
  }
}

