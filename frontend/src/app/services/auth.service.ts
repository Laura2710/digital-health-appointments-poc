import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';
import { tap } from 'rxjs/operators';

interface LoginResponse {
  token: string;
}

interface LoginRequest {
  username: string;
  password: string;
}

export interface JwtPayload {
  sub: string;
  role: 'ROLE_ADMIN' | 'ROLE_PATIENT';
  iat: number;
  exp: number;
}

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private readonly apiURL = 'http://localhost:8080/api/login';

  constructor(private readonly http: HttpClient) {}

  login(username: string, password: string) {
    const request: LoginRequest = { username, password };

    return this.http.post<LoginResponse>(this.apiURL, request).pipe(
      tap((response) => {
        localStorage.setItem('token', response.token);
      }),
    );
  }

  getRole() {
    const token = localStorage.getItem('token');
    if (!token) return null;
    const decoded = jwtDecode<JwtPayload>(token);

    return decoded.role;
  }
}
