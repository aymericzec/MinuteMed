/* tslint:disable */
import { Injectable } from '@angular/core';
import {
  HttpClient, HttpRequest, HttpResponse, 
  HttpHeaders, HttpParams } from '@angular/common/http';
import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators/map';
import { filter } from 'rxjs/operators/filter';

import { UserAccount } from '../models/user-account';

@Injectable()
export class AuthenticationRESTEndpointService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  findAllUsersResponse(): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/auth`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'text'
      });

    return this.http.request<any>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<any>;
        let _body: void = null;
        
        return _resp.clone({body: _body}) as HttpResponse<void>;
      })
    );
  }

  findAllUsers(): Observable<void> {
    return this.findAllUsersResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   createDataManagerAccountResponse(): Observable<HttpResponse<UserAccount>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/auth/create/datamanager`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<any>;
        let _body: UserAccount = null;
        _body = _resp.body as UserAccount
        return _resp.clone({body: _body}) as HttpResponse<UserAccount>;
      })
    );
  }

  /**
   * @return successful operation
   */
   createDataManagerAccount(): Observable<UserAccount> {
    return this.createDataManagerAccountResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   createDoctorAccountResponse(): Observable<HttpResponse<UserAccount>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/auth/create/doctor`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<any>;
        let _body: UserAccount = null;
        _body = _resp.body as UserAccount
        return _resp.clone({body: _body}) as HttpResponse<UserAccount>;
      })
    );
  }

  /**
   * @return successful operation
   */
   createDoctorAccount(): Observable<UserAccount> {
    return this.createDoctorAccountResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   createNurseAccountResponse(): Observable<HttpResponse<UserAccount>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/auth/create/nurse`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<any>;
        let _body: UserAccount = null;
        _body = _resp.body as UserAccount
        return _resp.clone({body: _body}) as HttpResponse<UserAccount>;
      })
    );
  }

  /**
   * @return successful operation
   */
   createNurseAccount(): Observable<UserAccount> {
    return this.createNurseAccountResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idAccount undefined
   */
   deleteUserResponse(idAccount: number): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "DELETE",
      this.rootUrl + `/auth/delete/${idAccount}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'text'
      });

    return this.http.request<any>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<any>;
        let _body: void = null;
        
        return _resp.clone({body: _body}) as HttpResponse<void>;
      })
    );
  }

  /**
   * @param idAccount undefined
   */
   deleteUser(idAccount: number): Observable<void> {
    return this.deleteUserResponse(idAccount).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `AuthenticationRESTEndpointService.AuthenticateUserParams` containing the following parameters:
   *
   * - `password`: 
   *
   * - `login`:
   */
   authenticateUserResponse(params: AuthenticationRESTEndpointService.AuthenticateUserParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/auth/login`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'text'
      });

    return this.http.request<any>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<any>;
        let _body: void = null;
        
        return _resp.clone({body: _body}) as HttpResponse<void>;
      })
    );
  }

  /**
   * @param params The `AuthenticationRESTEndpointService.AuthenticateUserParams` containing the following parameters:
   *
   * - `password`: 
   *
   * - `login`:
   */
   authenticateUser(params: AuthenticationRESTEndpointService.AuthenticateUserParams): Observable<void> {
    return this.authenticateUserResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param Authorization undefined
   */
   logoutResponse(Authorization?: string): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (Authorization != null) __headers = __headers.set("Authorization", Authorization.toString());
    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/auth/logout`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'text'
      });

    return this.http.request<any>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<any>;
        let _body: void = null;
        
        return _resp.clone({body: _body}) as HttpResponse<void>;
      })
    );
  }

  /**
   * @param Authorization undefined
   */
   logout(Authorization?: string): Observable<void> {
    return this.logoutResponse(Authorization).pipe(
      map(_r => _r.body)
    );
  }
}

export module AuthenticationRESTEndpointService {

  /**
   * Parameters for authenticateUser
   */
   export interface AuthenticateUserParams {

    password?: string;

    login?: string;
  }
}
