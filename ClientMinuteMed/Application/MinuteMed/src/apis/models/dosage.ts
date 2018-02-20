/* tslint:disable */
import { DosageReport } from './dosage-report';
import { MedicalRecord } from './medical-record';
import { Diagnostic } from './diagnostic';
import { Doctor } from './doctor';

export interface Dosage {

  reports: DosageReport[];

  title: string;

  medicalRecord: MedicalRecord;

  creationDate: string;

  diagnostic: Diagnostic;

  body: string;

  creator: Doctor;

  beginDosage: string;

  endDosage: string;

  draft: boolean;

  lastReport?: DosageReport;

  id?: number;
}
