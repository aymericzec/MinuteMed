/* tslint:disable */
import { NodeHU } from './node-hu';

export interface NodeCU {

  idNode?: number;

  floor: string;

  name: string;

  father: NodeHU;
}
