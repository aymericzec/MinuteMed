import { Component, OnInit } from '@angular/core';
import { MedicalStaff, MedicalRecordDTO, DiagnosticDTO } from '../api/models';
import { Router, ActivatedRoute } from '@angular/router';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import * as moment from 'moment';

@Component({
  selector: 'app-create-diagnostic',
  templateUrl: './create-diagnostic.component.html',
  styleUrls: ['./create-diagnostic.component.css']
})
export class CreateDiagnosticComponent implements OnInit {
  me: MedicalStaff;
  idDmp: number;
  md: MedicalRecordDTO;
  today = Date.now();
  title: string;
  diagnostic: string;

  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private medicalService: MedicalRecordsRESTEndpointService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.idDmp = this.route.snapshot.params['id'];

    this.staffService.getCurrentUserResponse().subscribe(
      response => {
        this.me = response.body;
    });

    this.medicalService.getMedicalRecord(this.idDmp).subscribe(
      response => {
        this.md = response;
    });
  }

  onSubmitCreate() {
    const diagnostic: DiagnosticDTO = {
        body : this.diagnostic,
        creationDate : moment().locale('fr').format('L'),
        draft : false,
        creatorId : this.me.idMedicalStaff,
        medicalRecordId : this.idDmp,
        title : this.title
      };

    this.medicalService.createDiagnosticResponse(this.idDmp, diagnostic).subscribe( response => {
      if (response.status === 201) {
        this.router.navigate(['/record/' + this.idDmp + '/diagnostics/' + JSON.parse(response.body)['idDiagnostic']]);
      }
    });
  }

}
