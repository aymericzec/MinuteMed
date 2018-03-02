import { Component, OnInit } from '@angular/core';
import { Exam } from '../../apis/models';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../../apis/services';
import { AuthService } from '../auth.service';
import { isNull } from 'util';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {

  cols: any;
  colsDoctor: any;
  exams: Exam[];
  examsTmp: any[][];
  id: number;
  constructor(private medicalService: MedicalRecordsRESTEndpointService,
     private authService: AuthService,
     private staffService: StaffRESTEndpointService,
     private route: ActivatedRoute) { }

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.medicalService.getExamsResponse(this.id).subscribe(response => {
          this.exams = response.body;
          this.examsTmp = [];

          for (let _i = 0; _i < this.exams.length; _i++) {
            let tat: any;
            tat = [];

            tat.push('nameDoctor');
            tat['nameDoctor'] = this.exams[_i].doctor.firstName + ' ' + this.exams[_i].doctor.lastName;

            tat.push('dateExam');
            tat['dateExam'] = this.exams[_i].dateExam;

            tat.push('title');
            tat['title'] = this.exams[_i].title;

            tat.push('identifiant');
            tat['identifiant'] = this.exams[_i].idExam;

            tat['description'] = this.exams[_i].description;
            tat.push('description');

            if (isNull(this.exams[_i].resultExam)) {
              tat['examinator'] = 'Pas encore réalisé';
              tat['dateExaminator'] = '??/??/????';
            } else {
              tat['examinator'] = this.exams[_i].resultExam.examinator.lastName + ' ' + this.exams[_i].resultExam.examinator.firstName;
              tat['dateExaminator'] = this.exams[_i].resultExam.examDate;
            }

            this.examsTmp.push(tat);
          }
      });

      this.cols = [
        { field: 'dateExam', header: 'Date de Création ' },
        { field: 'identifiant', header: 'Identifiant' },
        { field: 'title', header: 'Titre' },
        { field: 'nameDoctor', header: 'Prescripteur' },
        { field: 'examinator', header: 'Examinateur' },
        { field: 'dateExaminator', header: 'Examen effectué le' },
      ];
  }
}
