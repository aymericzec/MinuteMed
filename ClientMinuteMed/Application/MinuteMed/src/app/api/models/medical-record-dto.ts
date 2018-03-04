/* tslint:disable */
import { NodeDTO } from './node-dto';

export interface MedicalRecordDTO {

  id?: number;

  ss?: string;

  firstName?: string;

  lastName?: string;

  address?: string;

  cityBorn?: string;

  birthday?: string;

  gender?: string;

  phoneNumber?: string;

  email?: string;

  careUnit?: NodeDTO;
}
