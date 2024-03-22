import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormControl,
} from '@angular/forms';
import { ActiveToast, Toast, ToastrService } from 'ngx-toastr';

// Custom validator for special characters
function specialCharactersValidator(control: FormControl) {
  const regex = /^(?!.*\s\s)[a-zA-Z0-9@;*+\-\s.]*$/;
  const valid = regex.test(control.value);
  return valid ? null : { specialChars: true };
}

@Component({
  selector: 'app-create-note',
  templateUrl: './create-note.component.html',
  styleUrls: ['./create-note.component.css'],
})
export class CreateNoteComponent implements OnInit {
  addPostForm: FormGroup;

  constructor(
    private service: ServicesService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {
    this.addPostForm = this.formBuilder.group({
      title: [
        '',
        [
          Validators.required,
          specialCharactersValidator,
          Validators.maxLength(500),
        ],
      ],
      description: [
        '',
        [
          Validators.required,
          specialCharactersValidator,
          Validators.maxLength(500),
        ],
      ],
    });
  }

  ngOnInit(): void {}

  createNote() {
    if (this.addPostForm.invalid) {
      return;
    }

    const newPost = {
      title: this.addPostForm.value.title,
      description: this.addPostForm.value.description,
      id: this.service.getUser().id,
    };

    this.service.createNote(newPost).subscribe({
      next: () => {
        // Success: Reset the form
        this.toastr.success(
          'Note Successfully Penned and Saved',
          'Congratulations! 🎉',
          {
            timeOut: 3000,
          }
        );
        this.addPostForm.reset();
      },
      error: (error) => {
        // Error: Handle the error here
        this.toastr.error('Oops! Something Went Wrong', 'Failed', {
          timeOut: 3000,
        });
      },
    });
  }
}
