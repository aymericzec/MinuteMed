/* tslint:disable */
import { DosageReportDTO } from './dosage-report-dto';

export interface DosageDTO {

  creationDate?: string;

  id?: number;

  creatorId?: number;

  diagnosticId?: number;

  title?: string;

  medicalRecordId?: number;

  body?: string;

  beginDosage?: string;

  endDosage?: string;

  reports?: DosageReportDTO[];

  draft?: boolean;
}
