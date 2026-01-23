import { CanActivateFn, Router } from '@angular/router';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth.service';

export const authGuard: CanActivateFn = (route) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  if (!authService.isTokenValid()) {
    return router.createUrlTree(['/login']);
  }

  const requiredRole = route.data['role'];
  if (!requiredRole) {
    return true; // tous les rôles acceptés
  }

  const userRole = authService.getRole();
  if (userRole !== requiredRole) {
    return router.createUrlTree(['/forbidden']);
  }

  return true;
};
