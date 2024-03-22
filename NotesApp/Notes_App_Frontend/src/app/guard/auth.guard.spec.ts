import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CanActivate } from '@angular/router';

import { authGuard } from './auth.guard';

describe('AuthGuard', () => {
  let guard: CanActivate;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule], 
      providers: [authGuard], 
    });

    guard = TestBed.inject(authGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
