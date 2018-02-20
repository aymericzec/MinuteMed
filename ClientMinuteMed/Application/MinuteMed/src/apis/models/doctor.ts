/* tslint:disable */
import { Node } from './node';
import { Specialization } from './specialization';

export interface Doctor {

  idMedicalStaff?: number;

  status: string;

  firstName: string;

  lastName: string;

  address: string;

  email: string;

  phoneNumber: string;

  node: Node;

  specialization?: Specialization;
}
