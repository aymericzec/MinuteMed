/* tslint:disable */
import { NodeCU } from './node-cu';

export interface MedicalRecord {

  idMedicalRecord?: number;

  ss: string;

  firstName: string;

  lastName: string;

  address: string;

  birthday: string;

  gender: string;

  phoneNumber: string;

  email: string;

  cu?: NodeCU;
}
