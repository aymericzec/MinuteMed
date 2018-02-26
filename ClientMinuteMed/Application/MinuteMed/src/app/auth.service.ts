import { Injectable, Optional, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpResponse, HttpRequest } from '@angular/common/http';
import * as jwt_decode from 'jwt-decode';

@Injectable()
export class AuthService {
  private _jwt: string;
  protected basePath: string; // = 'http://conference.docker.localhost:90/conference-attendee/api/attendees/login';

  constructor(private router: Router, private http: HttpClient) {
    this.basePath = 'https:localhost:8080/ProjetMinuteMed/api/auth/login';
  }

  get jwt(): string {

    if (this._jwt) {
        return this._jwt;
    }


    // Retrieve the object from storage
    const retrievedObject = localStorage.getItem('jwt');
    this._jwt = retrievedObject;
    return this._jwt;
  }

  set jwt(val: string) {
    console.log('set jwt with : ' + val);

    if (!val) {
      localStorage.removeItem('jwt');
      this._jwt = undefined;
      return;
    }

    // Put the object into storage
    localStorage.setItem('jwt', val);
    this._jwt = val;
  }

  getTokenExpirationDate(token: string): Date {
    const decoded = jwt_decode(token);

    if (decoded.exp === undefined) {
      return null;
    }

    const date = new Date(0);
    date.setUTCSeconds(decoded.exp);
    return date;
  }

  isTokenExpired(token?: string): boolean {
    if (this.jwt === undefined || this.jwt == null) {
      return false;
    }

    const date = this.getTokenExpirationDate(token);
    if (date === undefined) {
      return false;
    }
    return !(date.valueOf() > new Date().valueOf());
  }


  login(token: string): void {
    console.log('Save token :', token);
    this.jwt = token;
  }

  logout(): void {
    this.jwt = undefined;
  }
}
