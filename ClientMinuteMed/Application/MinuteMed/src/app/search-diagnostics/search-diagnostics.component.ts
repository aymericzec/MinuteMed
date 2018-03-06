import { Component, OnInit } from '@angular/core';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService } from '../api/services';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { DiagnosticDTO, MedicalStaff, MedicalRecordDTO } from '../api/models';

@Component({
  selector: 'app-search-diagnostics',
  templateUrl: './search-diagnostics.component.html',
  styleUrls: ['./search-diagnostics.component.css']
})
export class SearchDiagnosticsComponent implements OnInit {

  cols: any;
  diagnostics: DiagnosticDTO[];
  diagnosticsTmp: any[][];
  id: number;
  test: string;
  me: MedicalRecordDTO;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private route: ActivatedRoute) { }

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.medicalService.getMedicalRecord(this.id).subscribe(dmp => {
          this.me = dmp;
      });

      this.medicalService.getDiagnostics(this.id).subscribe(response => {
          this.diagnostics = response;
          this.diagnosticsTmp = [];

          for (let _i = 0; _i < this.diagnostics.length; _i++) {
              this.staffService.getMedicalStaff(this.diagnostics[_i].creatorId).subscribe(responseDoctor => {
              let tat: any;
              tat = [];
              tat.push('nameDoctor');
              tat['nameDoctor'] = responseDoctor.firstname + ' ' + responseDoctor.lastname;

              tat.push('dateExam');
              tat['dateExam'] = this.diagnostics[_i].creationDate;

              tat.push('title');
              tat['title'] = this.diagnostics[_i].title;

              tat.push('identifiant');
              tat['identifiant'] = this.diagnostics[_i].id;

              this.diagnosticsTmp.push(tat);
            });
          }
      });

      this.cols = [
        { field: 'dateExam', header: 'Date de Création ' },
        { field: 'identifiant', header: 'Identifiant' },
        { field: 'title', header: 'Titre' },
        { field: 'nameDoctor', header: 'Docteur' },
      ];
  }


}
