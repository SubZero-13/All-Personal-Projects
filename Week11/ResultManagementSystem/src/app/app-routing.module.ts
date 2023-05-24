import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StudentResultComponent } from './student-result/student-result.component';
import { StudentSearchComponent } from './student-search/student-search.component';
import { TeacherAddComponent } from './teacher-add/teacher-add.component';
import { TeacherEditComponent } from './teacher-edit/teacher-edit.component';
import { TeacherLoginComponent } from './teacher-login/teacher-login.component';
import { TeacherResultComponent } from './teacher-result/teacher-result.component';
import { TeacherAuthGuard } from './auth/teacher-auth.guard';

const routes: Routes = [
  { component: HomeComponent, path: '' },
  { component: TeacherLoginComponent, path: 'tLogin' },
  {
    component: TeacherResultComponent, path: 'tResult',
    canActivate: [TeacherAuthGuard]
  },
  { component: StudentSearchComponent, path: 'search' },
  { component: StudentResultComponent, path: 'result' },
  {
    component: TeacherAddComponent, path: 'tAdd',
    canActivate: [TeacherAuthGuard]
  },
  {
    component: TeacherEditComponent, path: 'tEdit',
    canActivate: [TeacherAuthGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
