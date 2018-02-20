/* tslint:disable */
import { Doctor } from './doctor';

export interface ResultExam {

  idResultExam?: number;

  examinator: Doctor;

  examDate: string;

  body: string;

  files?: string[];
}
