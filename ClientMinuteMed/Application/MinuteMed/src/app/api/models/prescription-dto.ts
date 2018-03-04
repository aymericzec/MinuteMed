/* tslint:disable */

export interface PrescriptionDTO {

  id?: number;

  prescriptorId?: number;

  medicalRecordId?: number;

  diagnosticId?: number;

  title?: string;

  creationDate?: string;

  body?: string;

  draft?: boolean;
}
