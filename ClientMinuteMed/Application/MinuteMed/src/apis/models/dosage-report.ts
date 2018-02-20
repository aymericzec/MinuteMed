/* tslint:disable */
import { MedicalStaff } from './medical-staff';
import { Dosage } from './dosage';

export interface DosageReport {

  idReportDosage?: number;

  supervisor: MedicalStaff;

  creationDate: string;

  body: string;

  dosage: Dosage;
}
