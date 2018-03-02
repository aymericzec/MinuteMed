import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService } from '../../apis/services';
import { AuthService } from '../auth.service';
import { Exam } from '../../apis/models';
import { ActivatedRoute } from '@angular/router';
import { isNull } from 'util';

@Component({
  selector: 'app-consultexam',
  templateUrl: './consultexam.component.html',
  styleUrls: ['./consultexam.component.css']
})
export class ConsultexamComponent implements OnInit {
  exams: Exam[];
  cols: any[];
  exam: Exam;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idExam = this.route.snapshot.params['idExam'];

    class Test implements MedicalRecordsRESTEndpointService.GetExamParams {
      idRecord: number;
      idExam: number;

      constructor(idRecord: number, idExame: number) {
        this.idExam = idExame;
        this.idRecord = idRecord;
      }
    }

    const lolo = new Test(idDmp, idExam);

    this.medicalService.getExam(lolo).subscribe(e => {
      this.exam = e;
    });
  }
}
