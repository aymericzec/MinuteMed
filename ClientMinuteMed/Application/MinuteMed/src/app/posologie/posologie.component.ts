import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService } from '../../apis/services';
import { AuthService } from '../auth.service';
import { Prescription, Dosage } from '../../apis/models';

@Component({
  selector: 'app-posologie',
  templateUrl: './posologie.component.html',
  styleUrls: ['./posologie.component.css']
})
export class PosologieComponent implements OnInit {

  cols: any;
  colsDoctor: any;
  dosages: Dosage[];
  dosagesTmp: any[][];
  id: number;
  constructor(private medicalService: MedicalRecordsRESTEndpointService,
     private authService: AuthService,
     private staffService: StaffRESTEndpointService,
     private route: ActivatedRoute) { }

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.medicalService.getAllDosagesResponse(this.id).subscribe(response => {
          this.dosages = response.body;
          this.dosagesTmp = [];

          for (let _i = 0; _i < this.dosages.length; _i++) {
            let tat: any;
            tat = [];

            tat.push('nameDoctor');
            tat['nameDoctor'] = this.dosages[_i].creator.firstName + ' ' + this.dosages[_i].creator.lastName;

            tat.push('dateExam');
            tat['dateExam'] = this.dosages[_i].creationDate;

            tat.push('title');
            tat['title'] = this.dosages[_i].title;

            tat.push('idDiagnostic');
            tat['idDiagnostic'] = this.dosages[_i].diagnostic.idDiagnostic;

            tat.push('id');
            tat['id'] = this.dosages[_i].id;

            tat.push('endDosage');
            tat['endDosage'] = this.dosages[_i].endDosage;

            this.dosagesTmp.push(tat);
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
