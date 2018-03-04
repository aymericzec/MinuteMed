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

import { NodeAPHP } from '../models/node-aphp';
import { NodeHospital } from '../models/node-hospital';
import { NodePole } from '../models/node-pole';
import { NodeService } from '../models/node-service';
import { NodeHU } from '../models/node-hu';
import { NodeCU } from '../models/node-cu';

@Injectable()
export class ArborescenceRESTEndpointService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @return successful operation
   */
   getAPHPResponse(): Observable<HttpResponse<NodeAPHP>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP`,
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
        let _body: NodeAPHP = null;
        _body = _resp.body as NodeAPHP
        return _resp.clone({body: _body}) as HttpResponse<NodeAPHP>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAPHP(): Observable<NodeAPHP> {
    return this.getAPHPResponse().pipe(
      map(_r => _r.body)
    );
  }

  createAPHPResponse(): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/nodes/APHP`,
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

  createAPHP(): Observable<void> {
    return this.createAPHPResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   getAllHospitalsResponse(): Observable<HttpResponse<NodeHospital[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/hospitals`,
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
        let _body: NodeHospital[] = null;
        _body = _resp.body as NodeHospital[]
        return _resp.clone({body: _body}) as HttpResponse<NodeHospital[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllHospitals(): Observable<NodeHospital[]> {
    return this.getAllHospitalsResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   getAllPolesResponse(): Observable<HttpResponse<NodePole[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/hospitals/poles`,
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
        let _body: NodePole[] = null;
        _body = _resp.body as NodePole[]
        return _resp.clone({body: _body}) as HttpResponse<NodePole[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllPoles(): Observable<NodePole[]> {
    return this.getAllPolesResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   getAllServicesResponse(): Observable<HttpResponse<NodeService[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/hospitals/poles/services`,
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
        let _body: NodeService[] = null;
        _body = _resp.body as NodeService[]
        return _resp.clone({body: _body}) as HttpResponse<NodeService[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllServices(): Observable<NodeService[]> {
    return this.getAllServicesResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   getAllHospitalUnitsResponse(): Observable<HttpResponse<NodeHU[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/hospitals/poles/services/hUnits`,
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
        let _body: NodeHU[] = null;
        _body = _resp.body as NodeHU[]
        return _resp.clone({body: _body}) as HttpResponse<NodeHU[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllHospitalUnits(): Observable<NodeHU[]> {
    return this.getAllHospitalUnitsResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @return successful operation
   */
   getAllCareUnitsResponse(): Observable<HttpResponse<NodeCU[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/hospitals/poles/services/hUnits/cUnits`,
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
        let _body: NodeCU[] = null;
        _body = _resp.body as NodeCU[]
        return _resp.clone({body: _body}) as HttpResponse<NodeCU[]>;
      })
    );
  }

  /**
   * @return successful operation
   */
   getAllCareUnits(): Observable<NodeCU[]> {
    return this.getAllCareUnitsResponse().pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idAPHP undefined
   * @return successful operation
   */
   getHospitalsResponse(idAPHP: number): Observable<HttpResponse<NodeHospital[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${idAPHP}/hospitals`,
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
        let _body: NodeHospital[] = null;
        _body = _resp.body as NodeHospital[]
        return _resp.clone({body: _body}) as HttpResponse<NodeHospital[]>;
      })
    );
  }

  /**
   * @param idAPHP undefined
   * @return successful operation
   */
   getHospitals(idAPHP: number): Observable<NodeHospital[]> {
    return this.getHospitalsResponse(idAPHP).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idAPHP undefined
   */
   createHospitalResponse(idAPHP: number): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/nodes/APHP/${idAPHP}/hospitals`,
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
   * @param idAPHP undefined
   */
   createHospital(idAPHP: number): Observable<void> {
    return this.createHospitalResponse(idAPHP).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetHospitalParams` containing the following parameters:
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getHospitalResponse(params: ArborescenceRESTEndpointService.GetHospitalParams): Observable<HttpResponse<NodeHospital>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}`,
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
        let _body: NodeHospital = null;
        _body = _resp.body as NodeHospital
        return _resp.clone({body: _body}) as HttpResponse<NodeHospital>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetHospitalParams` containing the following parameters:
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getHospital(params: ArborescenceRESTEndpointService.GetHospitalParams): Observable<NodeHospital> {
    return this.getHospitalResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetPolesParams` containing the following parameters:
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getPolesResponse(params: ArborescenceRESTEndpointService.GetPolesParams): Observable<HttpResponse<NodePole[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles`,
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
        let _body: NodePole[] = null;
        _body = _resp.body as NodePole[]
        return _resp.clone({body: _body}) as HttpResponse<NodePole[]>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetPolesParams` containing the following parameters:
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getPoles(params: ArborescenceRESTEndpointService.GetPolesParams): Observable<NodePole[]> {
    return this.getPolesResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.CreatePoleParams` containing the following parameters:
   *
   * - `idHospital`: 
   *
   * - `idAPHP`:
   */
   createPoleResponse(params: ArborescenceRESTEndpointService.CreatePoleParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles`,
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
   * @param params The `ArborescenceRESTEndpointService.CreatePoleParams` containing the following parameters:
   *
   * - `idHospital`: 
   *
   * - `idAPHP`:
   */
   createPole(params: ArborescenceRESTEndpointService.CreatePoleParams): Observable<void> {
    return this.createPoleResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetPoleParams` containing the following parameters:
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getPoleResponse(params: ArborescenceRESTEndpointService.GetPoleParams): Observable<HttpResponse<NodePole>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;



    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}`,
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
        let _body: NodePole = null;
        _body = _resp.body as NodePole
        return _resp.clone({body: _body}) as HttpResponse<NodePole>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetPoleParams` containing the following parameters:
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getPole(params: ArborescenceRESTEndpointService.GetPoleParams): Observable<NodePole> {
    return this.getPoleResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetServicesParams` containing the following parameters:
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getServicesResponse(params: ArborescenceRESTEndpointService.GetServicesParams): Observable<HttpResponse<NodeService[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;



    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services`,
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
        let _body: NodeService[] = null;
        _body = _resp.body as NodeService[]
        return _resp.clone({body: _body}) as HttpResponse<NodeService[]>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetServicesParams` containing the following parameters:
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getServices(params: ArborescenceRESTEndpointService.GetServicesParams): Observable<NodeService[]> {
    return this.getServicesResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.CreateServiceParams` containing the following parameters:
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`:
   */
   createServiceResponse(params: ArborescenceRESTEndpointService.CreateServiceParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;



    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services`,
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
   * @param params The `ArborescenceRESTEndpointService.CreateServiceParams` containing the following parameters:
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`:
   */
   createService(params: ArborescenceRESTEndpointService.CreateServiceParams): Observable<void> {
    return this.createServiceResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetServiceParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getServiceResponse(params: ArborescenceRESTEndpointService.GetServiceParams): Observable<HttpResponse<NodeService>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;




    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services/${params.idService}`,
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
        let _body: NodeService = null;
        _body = _resp.body as NodeService
        return _resp.clone({body: _body}) as HttpResponse<NodeService>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetServiceParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getService(params: ArborescenceRESTEndpointService.GetServiceParams): Observable<NodeService> {
    return this.getServiceResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetHospitalUnitsParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getHospitalUnitsResponse(params: ArborescenceRESTEndpointService.GetHospitalUnitsParams): Observable<HttpResponse<NodeHU[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;




    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services/${params.idService}/hUnits`,
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
        let _body: NodeHU[] = null;
        _body = _resp.body as NodeHU[]
        return _resp.clone({body: _body}) as HttpResponse<NodeHU[]>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetHospitalUnitsParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getHospitalUnits(params: ArborescenceRESTEndpointService.GetHospitalUnitsParams): Observable<NodeHU[]> {
    return this.getHospitalUnitsResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.CreateHospitalUnitParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`:
   */
   createHospitalUnitResponse(params: ArborescenceRESTEndpointService.CreateHospitalUnitParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;




    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services/${params.idService}/hUnits`,
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
   * @param params The `ArborescenceRESTEndpointService.CreateHospitalUnitParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idAPHP`:
   */
   createHospitalUnit(params: ArborescenceRESTEndpointService.CreateHospitalUnitParams): Observable<void> {
    return this.createHospitalUnitResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetHospitalUnitParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idHU`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getHospitalUnitResponse(params: ArborescenceRESTEndpointService.GetHospitalUnitParams): Observable<HttpResponse<NodeHU>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;





    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services/${params.idService}/hUnits/${params.idHU}`,
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
        let _body: NodeHU = null;
        _body = _resp.body as NodeHU
        return _resp.clone({body: _body}) as HttpResponse<NodeHU>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetHospitalUnitParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idHU`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getHospitalUnit(params: ArborescenceRESTEndpointService.GetHospitalUnitParams): Observable<NodeHU> {
    return this.getHospitalUnitResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetCareUnitsParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idHU`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getCareUnitsResponse(params: ArborescenceRESTEndpointService.GetCareUnitsParams): Observable<HttpResponse<NodeCU[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services/${params.idService}/hUnits/${params.idHU}/cUnits`,
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
        let _body: NodeCU[] = null;
        _body = _resp.body as NodeCU[]
        return _resp.clone({body: _body}) as HttpResponse<NodeCU[]>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetCareUnitsParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idHU`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getCareUnits(params: ArborescenceRESTEndpointService.GetCareUnitsParams): Observable<NodeCU[]> {
    return this.getCareUnitsResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.CreateCareUnitParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idHU`: 
   *
   * - `idAPHP`:
   */
   createCareUnitResponse(params: ArborescenceRESTEndpointService.CreateCareUnitParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;





    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services/${params.idService}/hUnits/${params.idHU}/cUnits`,
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
   * @param params The `ArborescenceRESTEndpointService.CreateCareUnitParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idHU`: 
   *
   * - `idAPHP`:
   */
   createCareUnit(params: ArborescenceRESTEndpointService.CreateCareUnitParams): Observable<void> {
    return this.createCareUnitResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetCareUnitParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idHU`: 
   *
   * - `idCU`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getCareUnitResponse(params: ArborescenceRESTEndpointService.GetCareUnitParams): Observable<HttpResponse<NodeCU>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;






    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/nodes/APHP/${params.idAPHP}/hospitals/${params.idHospital}/poles/${params.idPole}/services/${params.idService}/hUnits/${params.idHU}/cUnits/${params.idCU}`,
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
        let _body: NodeCU = null;
        _body = _resp.body as NodeCU
        return _resp.clone({body: _body}) as HttpResponse<NodeCU>;
      })
    );
  }

  /**
   * @param params The `ArborescenceRESTEndpointService.GetCareUnitParams` containing the following parameters:
   *
   * - `idService`: 
   *
   * - `idPole`: 
   *
   * - `idHospital`: 
   *
   * - `idHU`: 
   *
   * - `idCU`: 
   *
   * - `idAPHP`: 
   *
   * @return successful operation
   */
   getCareUnit(params: ArborescenceRESTEndpointService.GetCareUnitParams): Observable<NodeCU> {
    return this.getCareUnitResponse(params).pipe(
      map(_r => _r.body)
    );
  }
}

export module ArborescenceRESTEndpointService {

  /**
   * Parameters for getHospital
   */
   export interface GetHospitalParams {

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for getPoles
   */
   export interface GetPolesParams {

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for createPole
   */
   export interface CreatePoleParams {

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for getPole
   */
   export interface GetPoleParams {

    idPole: number;

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for getServices
   */
   export interface GetServicesParams {

    idPole: number;

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for createService
   */
   export interface CreateServiceParams {

    idPole: number;

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for getService
   */
   export interface GetServiceParams {

    idService: number;

    idPole: number;

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for getHospitalUnits
   */
   export interface GetHospitalUnitsParams {

    idService: number;

    idPole: number;

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for createHospitalUnit
   */
   export interface CreateHospitalUnitParams {

    idService: number;

    idPole: number;

    idHospital: number;

    idAPHP: number;
  }

  /**
   * Parameters for getHospitalUnit
   */
   export interface GetHospitalUnitParams {

    idService: number;

    idPole: number;

    idHospital: number;

    idHU: number;

    idAPHP: number;
  }

  /**
   * Parameters for getCareUnits
   */
   export interface GetCareUnitsParams {

    idService: number;

    idPole: number;

    idHospital: number;

    idHU: number;

    idAPHP: number;
  }

  /**
   * Parameters for createCareUnit
   */
   export interface CreateCareUnitParams {

    idService: number;

    idPole: number;

    idHospital: number;

    idHU: number;

    idAPHP: number;
  }

  /**
   * Parameters for getCareUnit
   */
   export interface GetCareUnitParams {

    idService: number;

    idPole: number;

    idHospital: number;

    idHU: number;

    idCU: number;

    idAPHP: number;
  }
}
