import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-list-notes',
  templateUrl: './list-notes.component.html',
  styleUrls: ['./list-notes.component.css'],
})
export class ListNotesComponent implements OnInit {
  notes: any[] = [];

  maxNotesToShow = 10;
  constructor(private service: ServicesService, private toastr: ToastrService) {}

  ngOnInit(): void {
    this.loadRecentNotes();
  }

  loadRecentNotes(): void {
    this.service.getLatestNotes().subscribe({
      next: (data: any) => {
        this.notes = Array.isArray(data) ? data : [];
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

  deleteNote(id: any): void {
    if (confirm('Are you sure you want to delete this note?')) {
      this.service.deleteNote(id).subscribe({
        next: () => {
          this.toastr.success('Space for New Ideas Awaits', 'Note Vanished!', {
            timeOut: 3000,
          });
          this.loadRecentNotes();
        },
        error: (err) => {
          this.toastr.error('Oops! Something Went Wrong', 'Error', {
            timeOut: 3000,
          });
        },
      });
    }
  }
}
