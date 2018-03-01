import { Component, OnInit } from '@angular/core';
import { Exam } from '../../apis/models';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../../apis/services';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {

  cols: any;
  exams: Exam[];

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
     private authService: AuthService,
     private staffService: StaffRESTEndpointService) { }

  ngOnInit() {
      this.medicalService.getExamsResponse(1).subscribe(response => {
          this.exams = response.body;
          //this.exams.forEach(e => e.doctor = e.doctor.firstName + " " + e.doctor.lastName);
      });

      this.cols = [
        { field: 'dateExam', header: 'Date de Création ' },
        { field: 'title', header: 'Titre' },
        { field: 'description', header: 'Description' },
        { field: 'doctor', header: 'Prescripteur' },
        { field: 'gender', header: 'Examinateur' },
        { field: 'gender', header: 'Examen effectué le' }
      ];
  }

}
