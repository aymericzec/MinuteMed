import { Component, OnInit } from '@angular/core';
import { isNull } from 'util';
import { ActivatedRoute } from '@angular/router';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService } from '../../apis/services';
import { AuthService } from '../auth.service';
import { Prescription } from '../../apis/models';

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent implements OnInit {

  cols: any;
  colsDoctor: any;
  prescriptions: Prescription[];
  prescriptionsTmp: any[][];
  constructor(private medicalService: MedicalRecordsRESTEndpointService,
     private authService: AuthService,
     private staffService: StaffRESTEndpointService,
     private route: ActivatedRoute) { }

  ngOnInit() {
      const id = this.route.snapshot.params['id'];
      console.log(id);
      this.medicalService.getPrescriptions(id).subscribe(response => {
          this.prescriptions = response;
          this.prescriptionsTmp = [];

          for (let _i = 0; _i < this.prescriptions.length; _i++) {
            let tat: any;
            tat = [];

            tat.push('nameDoctor');
            tat['nameDoctor'] = this.prescriptions[_i].prescriptor.firstName + ' ' + this.prescriptions[_i].prescriptor.lastName;

            tat.push('dateExam');
            tat['dateExam'] = this.prescriptions[_i].creationDate;

            tat.push('title');
            tat['title'] = this.prescriptions[_i].title;

            tat.push('idDiagnostic');
            tat['idDiagnostic'] = this.prescriptions[_i].diagnostic.idDiagnostic;

            tat.push('id');
            tat['id'] = this.prescriptions[_i].idPrescription;

            this.prescriptionsTmp.push(tat);
          }
      });

      this.cols = [
        { field: 'dateExam', header: 'Date de Création ' },
        { field: 'id', header: 'Identifiant' },
        { field: 'title', header: 'Titre' },
        { field: 'nameDoctor', header: 'Prescripteur' },
        { field: 'idDiagnostic', header: 'Diagnostic rattaché' },
      ];
  }

  /*
  <th>Date</th>
  <th>Description</th>
  <th>Demandé par</th>
  <th>Réalisé par</th>
  <th>Effectué à</th>
  <th>Etat</th>*/

}
