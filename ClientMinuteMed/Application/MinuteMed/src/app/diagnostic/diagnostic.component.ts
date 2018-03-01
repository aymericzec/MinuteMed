import { Component, OnInit } from '@angular/core';
import { Diagnostic } from '../../apis/models';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../../apis/services';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-diagnostic',
  templateUrl: './diagnostic.component.html',
  styleUrls: ['./diagnostic.component.css']
})
export class DiagnosticComponent implements OnInit {

  cols: any;
  diagnostics: Diagnostic[];
  diagnosticsTmp: any[][];
  constructor(private medicalService: MedicalRecordsRESTEndpointService,
     private authService: AuthService,
     private staffService: StaffRESTEndpointService,
    private route: ActivatedRoute) { }

  ngOnInit() {
      const id = this.route.snapshot.params['id'];

      this.medicalService.getDiagnosticsResponse(id).subscribe(response => {
          this.diagnostics = response.body;
          this.diagnosticsTmp = [];

          for (let _i = 0; _i < this.diagnostics.length; _i++) {
            let tat: any;
            tat = [];

            tat.push('nameDoctor');
            tat['nameDoctor'] = this.diagnostics[_i].creator.firstName + ' ' + this.diagnostics[_i].creator.lastName;
            tat.push('dateExam');
            tat['dateExam'] = this.diagnostics[_i].creationDate;
            tat.push('title');
            tat['title'] = this.diagnostics[_i].title;
            tat.push('diagnostic');
            tat['diagnostic'] = this.diagnostics[_i].idDiagnostic;

            this.diagnosticsTmp.push(tat);
          }
      });

      this.cols = [
        { field: 'dateExam', header: 'Date de Création ' },
        { field: 'diagnostic', header: 'Identifiant' },
        { field: 'title', header: 'Titre' },
        { field: 'nameDoctor', header: 'Docteur' },
      ];
  }

}
