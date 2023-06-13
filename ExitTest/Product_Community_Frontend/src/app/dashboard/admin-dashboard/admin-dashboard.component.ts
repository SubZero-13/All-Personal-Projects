// admin-dashboard.component.ts
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/dataTypes/product';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  dataSource: MatTableDataSource<Product> = new MatTableDataSource<Product>();
  displayedColumns: string[] = ['productCode', 'productName', 'productBrand', 'productPrice', 'actions'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  products: any[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    this.productService.getAllProducts().subscribe(
      (products: Product[] | string) => {
        if (Array.isArray(products)) {
          this.dataSource = new MatTableDataSource<Product>(products);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        } else {
          // console.error('Failed to fetch products:', products);
        }
      },
      (error: any) => {
        // console.error('Error:', error);
      }
    );
  }


}
