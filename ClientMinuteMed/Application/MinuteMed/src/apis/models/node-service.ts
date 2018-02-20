/* tslint:disable */
import { NodePole } from './node-pole';

export interface NodeService {

  idNode?: number;

  floor: string;

  name: string;

  father: NodePole;
}
