/* tslint:disable */
import { Node } from './node';

export interface MedicalStaff {

  idMedicalStaff?: number;

  status: string;

  firstName: string;

  lastName: string;

  address: string;

  email: string;

  phoneNumber: string;

  node: Node;
}
