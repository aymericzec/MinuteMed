/* tslint:disable */
import { MedicalRecord } from './medical-record';
import { ResultExam } from './result-exam';
import { Doctor } from './doctor';

export interface Exam {

  idExam?: number;

  medicalRecord: MedicalRecord;

  title: string;

  description: string;

  dateExam: string;

  resultExam: ResultExam;

  draft: boolean;

  doctorAskExamination?: Doctor;
}
