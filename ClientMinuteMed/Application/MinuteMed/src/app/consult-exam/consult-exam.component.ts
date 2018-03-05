import { Component, OnInit } from '@angular/core';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';
import { ResultExamDTO, Doctor, MedicalRecordDTO, ExamDTO } from '../api/models';
import { isNull } from 'util';

@Component({
  selector: 'app-consult-exam',
  templateUrl: './consult-exam.component.html',
  styleUrls: ['./consult-exam.component.css']
})
export class ConsultExamComponent implements OnInit {

  cols: any[];
  exam: ExamDTO;
  record: MedicalRecordDTO;
  doctorCreate: Doctor;
  resultExam: ResultExamDTO;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute,
    private staffService: StaffRESTEndpointService ) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idExam = this.route.snapshot.params['idExam'];

    this.medicalService.getExam({'idRecord': idDmp, 'idExam': idExam}).subscribe(e => {
      this.exam = e;
      console.log(this.exam.description);
      this.staffService.getDoctor(e.doctorId).subscribe(response => {
        this.doctorCreate = response;
      });

      this.medicalService.getMedicalRecord(idDmp).subscribe(responseMR => {
        this.record = responseMR;
      });

      if (!isNull(this.exam.resultExam)) {
        /*this.medicalService.get(idDmp).subscribe(responseMR => {
          this.record = responseMR;
        });*/
      }


    });
  }

}
