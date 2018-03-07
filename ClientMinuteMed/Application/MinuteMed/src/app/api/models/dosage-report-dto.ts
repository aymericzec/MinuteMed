import { MedicalStaffDTO } from '../models';

/* tslint:disable */

export interface DosageReportDTO {

  id?: number;

  supervisor?: MedicalStaffDTO;

  dosageId?: number;

  creationDate?: string;

  body?: string;
}
