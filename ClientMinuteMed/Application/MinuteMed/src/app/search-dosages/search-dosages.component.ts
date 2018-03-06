import { Component, OnInit } from '@angular/core';
import { DosageDTO } from '../api/models';
import { AuthService } from '../auth.service';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-dosages',
  templateUrl: './search-dosages.component.html',
  styleUrls: ['./search-dosages.component.css']
})
export class SearchDosagesComponent implements OnInit {


  cols: any;
  colsDoctor: any;
  dosages: DosageDTO[];
  dosagesTmp: any[][];
  id: number;
  constructor(private medicalService: MedicalRecordsRESTEndpointService,
     private authService: AuthService,
     private staffService: StaffRESTEndpointService,
     private route: ActivatedRoute) { }

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.medicalService.getAllDosages(this.id).subscribe(response => {
          this.dosages = response;
          this.dosagesTmp = [];

          for (let _i = 0; _i < this.dosages.length; _i++) {
            this.staffService.getMedicalStaff(this.dosages[_i].creatorId).subscribe(responseDoctor => {
              let tat: any;
              tat = [];

              tat.push('nameDoctor');
              tat['nameDoctor'] = responseDoctor.firstname + ' ' + responseDoctor.lastname;

              tat.push('dateExam');
              tat['dateExam'] = this.dosages[_i].creationDate;

              tat.push('title');
              tat['title'] = this.dosages[_i].title;

              tat.push('idDiagnostic');
              tat['idDiagnostic'] = this.dosages[_i].diagnosticId;

              tat.push('id');
              tat['id'] = this.dosages[_i].id;

              tat.push('endDosage');
              tat['endDosage'] = this.dosages[_i].endDosage;

              this.dosagesTmp.push(tat);
            });
          }
      });

      this.cols = [
        { field: 'dateExam', header: 'Date de Création ' },
        { field: 'id', header: 'Identifiant' },
        { field: 'title', header: 'Titre' },
        { field: 'nameDoctor', header: 'Prescripteur' },
        { field: 'idDiagnostic', header: 'Diagnostic rattaché' },
        { field: 'endDosage', header: 'Fin du Dosage' },
      ];
  }
}
