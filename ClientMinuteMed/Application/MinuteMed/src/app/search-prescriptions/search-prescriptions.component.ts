import { Component, OnInit } from '@angular/core';
import { PrescriptionDTO } from '../api/models';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-prescriptions',
  templateUrl: './search-prescriptions.component.html',
  styleUrls: ['./search-prescriptions.component.css']
})
export class SearchPrescriptionsComponent implements OnInit {

  cols: any;
  colsDoctor: any;
  prescriptions: PrescriptionDTO[];
  prescriptionsTmp: any[][];
  id: number;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
     private authService: AuthService,
     private staffService: StaffRESTEndpointService,
     private route: ActivatedRoute) { }

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.medicalService.getPrescriptions(this.id).subscribe(response => {
          this.prescriptions = response;
          this.prescriptionsTmp = [];

          for (let _i = 0; _i < this.prescriptions.length; _i++) {
            this.staffService.getMedicalStaff(this.prescriptions[_i].prescriptorId).subscribe(responseDoctor => {
              let tat: any;
              tat = [];

              tat.push('nameDoctor');
              tat['nameDoctor'] = responseDoctor.firstname + ' ' + responseDoctor.lastname;

              tat.push('dateExam');
              tat['dateExam'] = this.prescriptions[_i].creationDate;

              tat.push('title');
              tat['title'] = this.prescriptions[_i].title;

              tat.push('idDiagnostic');
              tat['idDiagnostic'] = this.prescriptions[_i].diagnosticId;

              tat.push('id');
              tat['id'] = this.prescriptions[_i].id;

              this.prescriptionsTmp.push(tat);
            });
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
}
