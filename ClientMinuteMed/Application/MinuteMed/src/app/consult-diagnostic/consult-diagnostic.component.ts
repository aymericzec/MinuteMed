import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { MedicalRecordsRESTEndpointService } from '../../../afterGenSwagger/medical-records-restendpoint.service';
import { DiagnosticDTO } from '../api/models';

@Component({
  selector: 'app-consult-diagnostic',
  templateUrl: './consult-diagnostic.component.html',
  styleUrls: ['./consult-diagnostic.component.css']
})
export class ConsultDiagnosticComponent implements OnInit {

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
