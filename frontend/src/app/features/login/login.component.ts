import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  username = '';
  password = '';
  error = false;

  constructor(
    private readonly authService: AuthService,
    private readonly router: Router,
  ) {}

  login() {
    this.authService.login(this.username, this.password).subscribe({
      next: () => {
        console.log('login OK');
        const role = this.authService.getRole();
        console.log('role', role);
        if (role === 'ROLE_ADMIN') {
          this.router.navigate(['/admin']);
        } else if (role === 'ROLE_PATIENT') {
          this.router.navigate(['/patient']);
        }
      },
      error: (err) => {
        console.error('login KO', err);
      },
    });
  }
}
