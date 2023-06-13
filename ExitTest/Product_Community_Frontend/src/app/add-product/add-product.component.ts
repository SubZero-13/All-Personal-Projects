import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  productForm!: FormGroup;
  errorMessages: { [key: string]: string } = {};
  successMessage: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductService,
    private router: Router
  ) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.productForm = this.formBuilder.group({
      productCode: ['', Validators.required],
      productName: ['', Validators.required],
      productBrand: ['', Validators.required],
      productPrice: ['', [Validators.required, Validators.min(1)]],
      productDescription: ['', [Validators.required, Validators.maxLength(300), this.wordCountValidator]]
    });
  }

  get formControls() {
    return this.productForm.controls;
  }

  wordCountValidator(control: FormControl): { [key: string]: any } | null {
    const value: string = control.value;
    const words: string[] = value ? value.trim().split(/\s+/) : [];

    if (words.length > 300) {
      return { maxlength: true };
    }

    return null;
  }

  onSubmit() {
    if (this.productForm.invalid) {
      this.markAllFieldsAsTouched();
      return;
    }

    this.productService.getProductByCode(this.formControls['productCode'].value)
      .subscribe(
        () => {
          this.errorMessages['productCode'] = 'Product already exists with the given code';
          
        },
        () => {
          this.errorMessages['productCode'] = '';

          const product = {
            productCode: this.formControls['productCode'].value,
            productName: this.formControls['productName'].value,
            productBrand: this.formControls['productBrand'].value,
            productPrice: this.formControls['productPrice'].value,
            productDescription: this.formControls['productDescription'].value
          };

          this.productService.addProduct(product)
            .subscribe(
              () => {
                this.successMessage = 'Product added successfully';
                this.productForm.reset();
              },
              error => {
                this.errorMessages['genericError'] = error.error;
              }
            );
        }
      );
  }

  markAllFieldsAsTouched() {
    Object.values(this.productForm.controls).forEach(control => {
      control.markAsTouched();
    });
  }

  clearForm() {
    this.productForm.reset();
    this.errorMessages = {};
    this.successMessage = '';
  }

  redirectToDashboard() {
    this.router.navigate(['/user-dashboard']);
  }

}

