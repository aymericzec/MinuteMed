import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService } from '../../apis/services';
import { AuthService } from '../auth.service';
import { Exam } from '../../apis/models';

@Component({
  selector: 'app-consultexam',
  templateUrl: './consultexam.component.html',
  styleUrls: ['./consultexam.component.css']
})
export class ConsultexamComponent implements OnInit {
  exams: Exam[];
  cols: any[];

  constructor(private medicalService: MedicalRecordsRESTEndpointService, private authService: AuthService) { }

  ngOnInit() {
      this.medicalService.getExamsResponse(1).subscribe(response => {
          this.exams = response.body;
      });

      this.cols = [
        { field: 'idMedicalRecord', header: 'Identifiant' },
        { field: 'ss', header: 'Date de Création ' },
        { field: 'firstName', header: 'Titre' },
        { field: 'lastName', header: 'Description' },
        { field: 'gender', header: 'Brouillon' }
      ];
  }

}
