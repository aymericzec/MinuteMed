import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { ExamDTO, Doctor } from '../api/models';
import { ActivatedRoute } from '@angular/router';
import { isNull } from 'util';

@Component({
  selector: 'app-consultexam',
  templateUrl: './consultexam.component.html',
  styleUrls: ['./consultexam.component.css']
})
export class ConsultexamComponent implements OnInit {
  cols: any[];
  exam: ExamDTO;
  doctorCreate: Doctor;

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

    });
  }
}
