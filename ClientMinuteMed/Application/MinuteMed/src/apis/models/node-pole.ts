/* tslint:disable */
import { NodeHospital } from './node-hospital';

export interface NodePole {

  idNode?: number;

  floor: string;

  name: string;

  father: NodeHospital;
}
