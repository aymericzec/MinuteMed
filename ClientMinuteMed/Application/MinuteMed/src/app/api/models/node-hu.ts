/* tslint:disable */
import { NodeService } from './node-service';

export interface NodeHU {

  idNode?: number;

  floor: string;

  name: string;

  father: NodeService;
}
