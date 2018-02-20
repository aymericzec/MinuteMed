import { Injectable, Optional, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpResponse, HttpRequest } from '@angular/common/http';

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

    if (!val) {
      localStorage.removeItem('jwt');
      this._jwt = undefined;
      return;
    }

    // Put the object into storage
    localStorage.setItem('jwt', val);
    this._jwt = val;
  }

  get isLoggedIn(): boolean {
    return this.jwt !== undefined;
  }
/*
  login(login: string, password: string): Observable<any> {

    let headers: Headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    let body = `login=${login}&password=${password}`;

    let requestOptions: HttpRequest = {
      headers: headers
    };

    return this.http
      .post(this.basePath, body, requestOptions)
      .map((response: Response) => {
        if (response.status !== 200) {
          return undefined;
        }
        response.headers.getAll('authorization');

        this.jwt = response.headers.get('authorization');

        if (!this.jwt) {
          return undefined;
        }


        return this.jwt;

      })
      .catch((error: any) => {
        console.log(`An error has occured : ${error}`);
        return undefined;
      });

    // return undefined;
  }*/

  login(token: string): void {
    console.log('Save token :', token);
    this.jwt = token;
  }

  logout(): void {
    this.jwt = undefined;
  }
}
