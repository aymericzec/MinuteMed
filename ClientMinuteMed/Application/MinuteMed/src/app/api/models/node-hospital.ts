/* tslint:disable */
import { NodeAPHP } from './node-aphp';

export interface NodeHospital {

  idNode?: number;

  floor: string;

  name: string;

  father: NodeAPHP;
}
