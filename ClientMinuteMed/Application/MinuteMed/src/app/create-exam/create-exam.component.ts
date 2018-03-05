import { Component, OnInit } from '@angular/core';
import { ExamDTO, MedicalRecordDTO, MedicalStaff } from '../api/models';
import { Router, ActivatedRoute } from '@angular/router';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { DatePipe } from '@angular/common';
import * as moment from 'moment';

@Component({
  selector: 'app-create-exam',
  templateUrl: './create-exam.component.html',
  styleUrls: ['./create-exam.component.css']
})
export class CreateExamComponent implements OnInit {
  me: MedicalStaff;
  today = Date.now();
  md: MedicalRecordDTO;
  idDmp: number;
  title: string;
  description: string;
  dateToday: string;

  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private medicalService: MedicalRecordsRESTEndpointService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit() {
    this.idDmp = this.route.snapshot.params['id'];

    this.staffService.getCurrentUserResponse().subscribe(
      response => {
        this.me = response.body;
    });

    this.medicalService.getMedicalRecord(this.idDmp).subscribe(
      response => {
        this.md = response;
    });
  }

  onSubmitCreate() {
    const exam: ExamDTO = {
        'medicalRecordId' : this.md.id,
        'title': this.title,
        'description': this.description,
        'dateExam': moment().locale('fr').format('L'),
        'draft': false,
        'doctorId': this.me.idMedicalStaff
      };

    this.medicalService.createExamResponse(this.idDmp, exam).subscribe( response => {
      if (response.status === 201) {
        this.router.navigate(['/record/' + 1 + '/exams/' + JSON.parse(response.body)['idExam']]);
      }
    });
  }


}
