/* tslint:disable */
import { ResultExamDTO } from './result-exam-dto';

export interface ExamDTO {

  id?: number;

  doctorId?: number;

  medicalRecordId?: number;

  title?: string;

  description?: string;

  dateExam?: string;

  resultExam?: ResultExamDTO;

  draft?: boolean;
}
