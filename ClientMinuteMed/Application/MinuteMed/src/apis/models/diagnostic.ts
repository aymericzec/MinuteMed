/* tslint:disable */
import { Doctor } from './doctor';
import { MedicalRecord } from './medical-record';

export interface Diagnostic {

  idDiagnostic?: number;

  creator: Doctor;

  medicalRecord: MedicalRecord;

  title: string;

  creationDate: string;

  body: string;

  draft: boolean;
}
