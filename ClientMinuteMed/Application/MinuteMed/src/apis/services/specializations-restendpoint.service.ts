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

import { Specialization } from '../models/specialization';

@Injectable()
export class SpecializationsRESTEndpointService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @return successful operation
   */
   getAllSpecializationsResponse(): Observable<HttpResponse<Specialization[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/specializations`,
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
        let _body: Specialization[] = null;
        _body = _resp.body as Specialization[]
        return _resp.clone({body: _body}) as HttpResponse<Specialization[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllSpecializations(): Observable<Specialization[]> {
    return this.getAllSpecializationsResponse().pipe(
      map(_r => _r.body)
    );
  }
}

export module SpecializationsRESTEndpointService {
}
