import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';
import { DiagnosticDTO } from '../api/models';

@Component({
  selector: 'app-consultdiagnostic',
  templateUrl: './consultdiagnostic.component.html',
  styleUrls: ['./consultdiagnostic.component.css']
})
export class ConsultdiagnosticComponent implements OnInit {

  diagnostic: DiagnosticDTO;


  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idDiag = this.route.snapshot.params['idDiagnostic'];

    this.medicalService.getDiagnostic({'idRecord': idDmp, 'idDiagnostic': idDiag}).subscribe(d => {
      this.diagnostic = d;
    });
  }



}
