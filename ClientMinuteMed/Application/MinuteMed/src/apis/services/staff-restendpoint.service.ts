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

import { MedicalStaff } from '../models/medical-staff';
import { DataManager } from '../models/data-manager';
import { Doctor } from '../models/doctor';
import { Nurse } from '../models/nurse';
import { AuthService } from '../../app/auth.service';

@Injectable()
export class StaffRESTEndpointService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @return successful operation
   */
   getAllStaffsResponse(): Observable<HttpResponse<MedicalStaff[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/staffs`,
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
        let _body: MedicalStaff[] = null;
        _body = _resp.body as MedicalStaff[]
        return _resp.clone({body: _body}) as HttpResponse<MedicalStaff[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllStaffs(): Observable<MedicalStaff[]> {
    return this.getAllStaffsResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idDataManager undefined
   * @return successful operation
   */
   getDatamanagerResponse(idDataManager: number): Observable<HttpResponse<DataManager>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/staffs/dataManagers/${idDataManager}`,
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
        let _body: DataManager = null;
        _body = _resp.body as DataManager
        return _resp.clone({body: _body}) as HttpResponse<DataManager>;
      })
    );
  }

  /**
   * @param idDataManager undefined
   * @return successful operation
   */
   getDatamanager(idDataManager: number): Observable<DataManager> {
    return this.getDatamanagerResponse(idDataManager).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   getAllDoctorsResponse(): Observable<HttpResponse<Doctor[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/staffs/doctors`,
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
        let _body: Doctor[] = null;
        _body = _resp.body as Doctor[]
        return _resp.clone({body: _body}) as HttpResponse<Doctor[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllDoctors(): Observable<Doctor[]> {
    return this.getAllDoctorsResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idDoctor undefined
   * @return successful operation
   */
   getDoctorResponse(idDoctor: number): Observable<HttpResponse<Doctor>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/staffs/doctors/${idDoctor}`,
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
        let _body: Doctor = null;
        _body = _resp.body as Doctor
        return _resp.clone({body: _body}) as HttpResponse<Doctor>;
      })
    );
  }

  /**
   * @param idDoctor undefined
   * @return successful operation
   */
   getDoctor(idDoctor: number): Observable<Doctor> {
    return this.getDoctorResponse(idDoctor).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idDoctor undefined
   */
   deleteDoctorResponse(idDoctor: number): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "DELETE",
      this.rootUrl + `/staffs/doctors/${idDoctor}`,
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
   * @param idDoctor undefined
   */
   deleteDoctor(idDoctor: number): Observable<void> {
    return this.deleteDoctorResponse(idDoctor).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   getAllNursesResponse(): Observable<HttpResponse<Nurse[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/staffs/nurses`,
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
        let _body: Nurse[] = null;
        _body = _resp.body as Nurse[]
        return _resp.clone({body: _body}) as HttpResponse<Nurse[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllNurses(): Observable<Nurse[]> {
    return this.getAllNursesResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idNurse undefined
   * @return successful operation
   */
   getNurseResponse(idNurse: number): Observable<HttpResponse<Nurse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/staffs/nurses/${idNurse}`,
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
        let _body: Nurse = null;
        _body = _resp.body as Nurse
        return _resp.clone({body: _body}) as HttpResponse<Nurse>;
      })
    );
  }

  /**
   * @param idNurse undefined
   * @return successful operation
   */
   getNurse(idNurse: number): Observable<Nurse> {
    return this.getNurseResponse(idNurse).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idNurse undefined
   */
   deleteNurseResponse(idNurse: number): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "DELETE",
      this.rootUrl + `/staffs/nurses/${idNurse}`,
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
   * @param idNurse undefined
   */
   deleteNurse(idNurse: number): Observable<void> {
    return this.deleteNurseResponse(idNurse).pipe(
      map(_r => _r.body)
    );
  }


  /**
   * @param idNurse undefined
   */
  getMe(): Observable<HttpResponse<MedicalStaff>> {
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<MedicalStaff>(
      "GET",
      this.rootUrl + `/staffs/me`,
      __body,
      {
        headers: __headers,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<MedicalStaff>;
        let _body: MedicalStaff = null;
        _body = _resp.body as MedicalStaff
        return _resp.clone({body: _body}) as HttpResponse<MedicalStaff>;
      })
    );
  }


}

export module StaffRESTEndpointService {
}
