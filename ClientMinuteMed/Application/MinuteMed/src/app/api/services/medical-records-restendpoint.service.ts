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

import { MedicalRecordDTO } from '../models/medical-record-dto';
import { DiagnosticDTO } from '../models/diagnostic-dto';
import { DosageDTO } from '../models/dosage-dto';
import { ExamDTO } from '../models/exam-dto';
import { PrescriptionDTO } from '../models/prescription-dto';

@Injectable()
export class MedicalRecordsRESTEndpointService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param Authorization undefined
   * @return successful operation
   */
   getAllMedicalRecordResponse(Authorization?: string): Observable<HttpResponse<MedicalRecordDTO[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (Authorization != null) __headers = __headers.set("Authorization", Authorization.toString());
    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records`,
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
        let _body: MedicalRecordDTO[] = null;
        _body = _resp.body as MedicalRecordDTO[]
        return _resp.clone({body: _body}) as HttpResponse<MedicalRecordDTO[]>;
      })
    );
  }

  /**
   * @param Authorization undefined
   * @return successful operation
   */
   getAllMedicalRecord(Authorization?: string): Observable<MedicalRecordDTO[]> {
    return this.getAllMedicalRecordResponse(Authorization).pipe(
      map(_r => _r.body)
    );
  }

  createMedicalRecordResponse(record: MedicalRecordDTO): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: MedicalRecordDTO = record;
    let req = new HttpRequest<MedicalRecordDTO>(
      "POST",
      this.rootUrl + `/records`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'text'
      });

    return this.http.request<MedicalRecordDTO>(req).pipe(
      filter(_r => _r instanceof HttpResponse),
      map(_r => {
        let _resp = _r as HttpResponse<any>;
        let _body: void = null;

        return _resp.clone({body: _body}) as HttpResponse<void>;
      })
    );
  }

  createMedicalRecord(record: MedicalRecordDTO): Observable<void> {
    return this.createMedicalRecordResponse(record).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getMedicalRecordResponse(idRecord: number): Observable<HttpResponse<MedicalRecordDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${idRecord}`,
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
        let _body: MedicalRecordDTO = null;
        _body = _resp.body as MedicalRecordDTO
        return _resp.clone({body: _body}) as HttpResponse<MedicalRecordDTO>;
      })
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getMedicalRecord(idRecord: number): Observable<MedicalRecordDTO> {
    return this.getMedicalRecordResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   */
   deleteMedicalRecordResponse(idRecord: number): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "DELETE",
      this.rootUrl + `/records/${idRecord}`,
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
   * @param idRecord undefined
   */
   deleteMedicalRecord(idRecord: number): Observable<void> {
    return this.deleteMedicalRecordResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getDiagnosticsResponse(idRecord: number): Observable<HttpResponse<DiagnosticDTO[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${idRecord}/diagnostics`,
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
        let _body: DiagnosticDTO[] = null;
        _body = _resp.body as DiagnosticDTO[]
        return _resp.clone({body: _body}) as HttpResponse<DiagnosticDTO[]>;
      })
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getDiagnostics(idRecord: number): Observable<DiagnosticDTO[]> {
    return this.getDiagnosticsResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   */
   createDiagnosticResponse(idRecord: number): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/records/${idRecord}/diagnostics`,
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
   * @param idRecord undefined
   */
   createDiagnostic(idRecord: number): Observable<void> {
    return this.createDiagnosticResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.GetDiagnosticParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idDiagnostic`:
   *
   * @return successful operation
   */
   getDiagnosticResponse(params: MedicalRecordsRESTEndpointService.GetDiagnosticParams): Observable<HttpResponse<DiagnosticDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${params.idRecord}/diagnostics/${params.idDiagnostic}`,
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
        let _body: DiagnosticDTO = null;
        _body = _resp.body as DiagnosticDTO
        return _resp.clone({body: _body}) as HttpResponse<DiagnosticDTO>;
      })
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.GetDiagnosticParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idDiagnostic`:
   *
   * @return successful operation
   */
   getDiagnostic(params: MedicalRecordsRESTEndpointService.GetDiagnosticParams): Observable<DiagnosticDTO> {
    return this.getDiagnosticResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.DeleteDiagnosticParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idDiagnostic`:
   */
   deleteDiagnosticResponse(params: MedicalRecordsRESTEndpointService.DeleteDiagnosticParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "DELETE",
      this.rootUrl + `/records/${params.idRecord}/diagnostics/${params.idDiagnostic}`,
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
   * @param params The `MedicalRecordsRESTEndpointService.DeleteDiagnosticParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idDiagnostic`:
   */
   deleteDiagnostic(params: MedicalRecordsRESTEndpointService.DeleteDiagnosticParams): Observable<void> {
    return this.deleteDiagnosticResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getAllDosagesResponse(idRecord: number): Observable<HttpResponse<DosageDTO[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${idRecord}/dosages`,
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
        let _body: DosageDTO[] = null;
        _body = _resp.body as DosageDTO[]
        return _resp.clone({body: _body}) as HttpResponse<DosageDTO[]>;
      })
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getAllDosages(idRecord: number): Observable<DosageDTO[]> {
    return this.getAllDosagesResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   */
   createDosageResponse(idRecord: number): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/records/${idRecord}/dosages`,
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
   * @param idRecord undefined
   */
   createDosage(idRecord: number): Observable<void> {
    return this.createDosageResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.GetDosageParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idDosage`:
   *
   * @return successful operation
   */
   getDosageResponse(params: MedicalRecordsRESTEndpointService.GetDosageParams): Observable<HttpResponse<DosageDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${params.idRecord}/dosages/${params.idDosage}`,
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
        let _body: DosageDTO = null;
        _body = _resp.body as DosageDTO
        return _resp.clone({body: _body}) as HttpResponse<DosageDTO>;
      })
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.GetDosageParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idDosage`:
   *
   * @return successful operation
   */
   getDosage(params: MedicalRecordsRESTEndpointService.GetDosageParams): Observable<DosageDTO> {
    return this.getDosageResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.DeleteDosageParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idDosage`:
   */
   deleteDosageResponse(params: MedicalRecordsRESTEndpointService.DeleteDosageParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "DELETE",
      this.rootUrl + `/records/${params.idRecord}/dosages/${params.idDosage}`,
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
   * @param params The `MedicalRecordsRESTEndpointService.DeleteDosageParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idDosage`:
   */
   deleteDosage(params: MedicalRecordsRESTEndpointService.DeleteDosageParams): Observable<void> {
    return this.deleteDosageResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getExamsResponse(idRecord: number): Observable<HttpResponse<ExamDTO[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${idRecord}/exams`,
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
        let _body: ExamDTO[] = null;
        _body = _resp.body as ExamDTO[]
        return _resp.clone({body: _body}) as HttpResponse<ExamDTO[]>;
      })
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getExams(idRecord: number): Observable<ExamDTO[]> {
    return this.getExamsResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   */
   createExamResponse(idRecord: number, exam:ExamDTO): Observable<HttpResponse<string>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: ExamDTO = exam;

    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/records/${idRecord}/exams`,
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
        let _body: string = _resp.body;

        return _resp.clone({body: _body}) as HttpResponse<string>;
      })
    );
  }

  /**
   * @param idRecord undefined
   */
   createExam(idRecord: number, exam:ExamDTO): Observable<string> {
    return this.createExamResponse(idRecord, exam).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.GetExamParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idExam`:
   *
   * @return successful operation
   */
   getExamResponse(params: MedicalRecordsRESTEndpointService.GetExamParams): Observable<HttpResponse<ExamDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${params.idRecord}/exams/${params.idExam}`,
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
        let _body: ExamDTO = null;
        _body = _resp.body as ExamDTO
        return _resp.clone({body: _body}) as HttpResponse<ExamDTO>;
      })
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.GetExamParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idExam`:
   *
   * @return successful operation
   */
   getExam(params: MedicalRecordsRESTEndpointService.GetExamParams): Observable<ExamDTO> {
    return this.getExamResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.DeleteExamParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idExam`:
   */
   deleteExamResponse(params: MedicalRecordsRESTEndpointService.DeleteExamParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "DELETE",
      this.rootUrl + `/records/${params.idRecord}/exams/${params.idExam}`,
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
   * @param params The `MedicalRecordsRESTEndpointService.DeleteExamParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idExam`:
   */
   deleteExam(params: MedicalRecordsRESTEndpointService.DeleteExamParams): Observable<void> {
    return this.deleteExamResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getPrescriptionsResponse(idRecord: number): Observable<HttpResponse<PrescriptionDTO[]>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${idRecord}/prescriptions`,
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
        let _body: PrescriptionDTO[] = null;
        _body = _resp.body as PrescriptionDTO[]
        return _resp.clone({body: _body}) as HttpResponse<PrescriptionDTO[]>;
      })
    );
  }

  /**
   * @param idRecord undefined
   * @return successful operation
   */
   getPrescriptions(idRecord: number): Observable<PrescriptionDTO[]> {
    return this.getPrescriptionsResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param idRecord undefined
   */
   createPrescriptionResponse(idRecord: number): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      "POST",
      this.rootUrl + `/records/${idRecord}/prescriptions`,
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
   * @param idRecord undefined
   */
   createPrescription(idRecord: number): Observable<void> {
    return this.createPrescriptionResponse(idRecord).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.GetPrescriptionParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idPrescription`:
   *
   * @return successful operation
   */
   getPrescriptionResponse(params: MedicalRecordsRESTEndpointService.GetPrescriptionParams): Observable<HttpResponse<PrescriptionDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "GET",
      this.rootUrl + `/records/${params.idRecord}/prescriptions/${params.idPrescription}`,
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
        let _body: PrescriptionDTO = null;
        _body = _resp.body as PrescriptionDTO
        return _resp.clone({body: _body}) as HttpResponse<PrescriptionDTO>;
      })
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.GetPrescriptionParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idPrescription`:
   *
   * @return successful operation
   */
   getPrescription(params: MedicalRecordsRESTEndpointService.GetPrescriptionParams): Observable<PrescriptionDTO> {
    return this.getPrescriptionResponse(params).pipe(
      map(_r => _r.body)
    );
  }

  /**
   * @param params The `MedicalRecordsRESTEndpointService.DeletePrescriptionParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idPrescription`:
   */
   deletePrescriptionResponse(params: MedicalRecordsRESTEndpointService.DeletePrescriptionParams): Observable<HttpResponse<void>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      "DELETE",
      this.rootUrl + `/records/${params.idRecord}/prescriptions/${params.idPrescription}`,
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
   * @param params The `MedicalRecordsRESTEndpointService.DeletePrescriptionParams` containing the following parameters:
   *
   * - `idRecord`:
   *
   * - `idPrescription`:
   */
   deletePrescription(params: MedicalRecordsRESTEndpointService.DeletePrescriptionParams): Observable<void> {
    return this.deletePrescriptionResponse(params).pipe(
      map(_r => _r.body)
    );
  }
}

export module MedicalRecordsRESTEndpointService {

  /**
   * Parameters for getDiagnostic
   */
   export interface GetDiagnosticParams {

    idRecord: number;

    idDiagnostic: number;
  }

  /**
   * Parameters for deleteDiagnostic
   */
   export interface DeleteDiagnosticParams {

    idRecord: number;

    idDiagnostic: number;
  }

  /**
   * Parameters for getDosage
   */
   export interface GetDosageParams {

    idRecord: number;

    idDosage: number;
  }

  /**
   * Parameters for deleteDosage
   */
   export interface DeleteDosageParams {

    idRecord: number;

    idDosage: number;
  }

  /**
   * Parameters for getExam
   */
   export interface GetExamParams {

    idRecord: number;

    idExam: number;
  }

  /**
   * Parameters for deleteExam
   */
   export interface DeleteExamParams {

    idRecord: number;

    idExam: number;
  }

  /**
   * Parameters for getPrescription
   */
   export interface GetPrescriptionParams {

    idRecord: number;

    idPrescription: number;
  }

  /**
   * Parameters for deletePrescription
   */
   export interface DeletePrescriptionParams {

    idRecord: number;

    idPrescription: number;
  }
}
