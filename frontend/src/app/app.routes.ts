import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminPageComponent } from './admin/admin-page.component';
import { PatientPageComponent } from './patient/patient-page/patient-page.component';

export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'admin',
    component: AdminPageComponent,
  },
  {
    path: 'patient',
    component: PatientPageComponent,
  },
];
