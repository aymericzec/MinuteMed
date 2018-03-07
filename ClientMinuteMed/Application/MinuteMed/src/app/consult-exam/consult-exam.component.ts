import { Component, OnInit } from '@angular/core';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';
import { ResultExamDTO, Doctor, MedicalRecordDTO, ExamDTO, MedicalStaff, MedicalStaffDTO } from '../api/models';
import { isNull } from 'util';
import * as moment from 'moment';


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
  idDmp: number;
  idExam: number;
  bodyResultExam: string;
  today = Date.now();
  resultExamDoctor: MedicalStaffDTO;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute,
    private staffService: StaffRESTEndpointService ) { }

  ngOnInit() {
    this.idDmp = this.route.snapshot.params['id'];
    this.idExam = this.route.snapshot.params['idExam'];

    this.medicalService.getExam({'idRecord': this.idDmp, 'idExam': this.idExam}).subscribe(e => {
      this.exam = e;
      this.staffService.getDoctor(e.doctorId).subscribe(response => {
        this.doctorCreate = response;
      });

      this.medicalService.getMedicalRecord(this.idDmp).subscribe(responseMR => {
        this.record = responseMR;
      });

      if (!isNull(this.exam.resultExam)) {
        this.resultExam = this.exam.resultExam;
        console.log('Result examn existe');
        this.staffService.getMedicalStaff(this.exam.doctorId).subscribe(responseDoctor => {
          this.resultExamDoctor = responseDoctor;
        });
      }
    });
  }

  onSubmitCreateReport () {
    this.staffService.getCurrentUser().subscribe(doctor => {
      const resultExam: ResultExamDTO = {
        body: this.bodyResultExam,
        examDate: moment().locale('fr').format('L'),
        examinatorId: doctor.idMedicalStaff,
        idExam: this.idExam
      };

      this.medicalService.createResultExamResponse(this.idDmp, resultExam).subscribe(response => {
        if (response.status === 201) {
          this.resultExam = resultExam;
          this.resultExamDoctor = {
            firstname: doctor.firstName,
            lastname: doctor.lastName
          };
          console.log('insertion réussi, il faut caché le truc' + doctor.lastName);
        }
      });
    });
  }

}
