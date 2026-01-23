import { Routes } from '@angular/router';
import { LoginComponent } from './features/login/login.component';
import { AdminPageComponent } from './features/admin/admin-page.component';
import { PatientPageComponent } from './features/patient/patient-page/patient-page.component';
import { authGuard } from './core/auth.guard';
import { ForbiddenComponent } from './pages/forbidden/forbidden.component';

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
    canActivate: [authGuard],
    data: { role: 'ROLE_ADMIN' },
  },
  {
    path: 'patient',
    component: PatientPageComponent,
    canActivate: [authGuard],
    data: { role: 'ROLE_PATIENT' },
  },
  {
    path: 'forbidden',
    component: ForbiddenComponent,
  },
];
