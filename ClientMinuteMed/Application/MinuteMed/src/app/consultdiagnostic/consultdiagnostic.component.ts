import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../../apis/services';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';
import { Diagnostic } from '../../apis/models';

@Component({
  selector: 'app-consultdiagnostic',
  templateUrl: './consultdiagnostic.component.html',
  styleUrls: ['./consultdiagnostic.component.css']
})
export class ConsultdiagnosticComponent implements OnInit {

  diagnostic: Diagnostic;


  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idDiag = this.route.snapshot.params['idDiagnostic'];

    class Test implements MedicalRecordsRESTEndpointService.GetDiagnosticParams {
      idRecord: number;
      idDiagnostic: number;

      constructor(idRecord: number, idDiagnostic: number) {
        this.idDiagnostic = idDiagnostic;
        this.idRecord = idRecord;
      }
    }

    const lolo = new Test(idDmp, idDiag);

    this.medicalService.getDiagnostic(lolo).subscribe(d => {
      this.diagnostic = d;
    });
  }



}
