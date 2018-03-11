import { Component, OnInit } from '@angular/core';
import { isNull } from 'util';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService } from '../api/services';
import { ExamDTO, MedicalStaffDTO, MedicalRecordDTO } from '../api/models';

@Component({
  selector: 'app-search-exams',
  templateUrl: './search-exams.component.html',
  styleUrls: ['./search-exams.component.css']
})
export class SearchExamsComponent implements OnInit {
  cols: any;
  colsDoctor: any;
  exams: ExamDTO[];
  examsTmp: any[][];
  id: number;
  examResultDoctor: MedicalStaffDTO;
  record: MedicalRecordDTO;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];

    this.medicalService.getMedicalRecord(this.id).subscribe(dmp => {
      this.record = dmp;
    });

    this.medicalService.getExams(this.id).subscribe(response => {
      this.exams = response;
      console.log(this.id);
      console.log(this.exams);
      this.examsTmp = [];

      for (let _i = 0; _i < this.exams.length; _i++) {
        this.staffService.getMedicalStaff(this.exams[_i].doctorId).subscribe(responseDoctor => {
          let tat: any;
          tat = [];

          tat.push('nameDoctor');
          tat['nameDoctor'] = responseDoctor.firstname + ' ' + responseDoctor.lastname;

          tat.push('dateExam');
          tat['dateExam'] = this.exams[_i].dateExam;

          tat.push('title');
          tat['title'] = this.exams[_i].title;

          tat.push('identifiant');
          tat['identifiant'] = this.exams[_i].id;

          tat['description'] = this.exams[_i].description;
          tat.push('description');


          if (isNull(this.exams[_i].resultExam)) {
            tat['examinator'] = 'Pas encore réalisé';
            tat['dateExaminator'] = '??/??/????';
          } else {
            this.staffService.getMedicalStaff(this.exams[_i].resultExam.examinatorId).subscribe(responseDoctorResult => {
              tat['examinator'] = responseDoctorResult.lastname + ' ' + responseDoctorResult.firstname;
              tat['dateExaminator'] = this.exams[_i].resultExam.examDate;
            });
          }
          this.examsTmp.push(tat);
        });
      }
    });

    this.cols = [
      { field: 'dateExam', header: 'Date de Création ' },
      { field: 'title', header: 'Titre' },
      { field: 'nameDoctor', header: 'Prescripteur' },
      { field: 'examinator', header: 'Examinateur' },
      { field: 'dateExaminator', header: 'Examen effectué le' },
    ];
  }

  visitExam(rowData: any) {
    this.router.navigate(['/record/' + this.id + '/exams/' + rowData.identifiant]);
  }
}
