/* tslint:disable */
import { Doctor } from './doctor';
import { MedicalRecord } from './medical-record';
import { Diagnostic } from './diagnostic';

export interface Prescription {

  idPrescription?: number;

  prescriptor: Doctor;

  medicalRecord: MedicalRecord;

  diagnostic?: Diagnostic;

  title: string;

  creationDate: string;

  body: string;

  draft: boolean;
}
