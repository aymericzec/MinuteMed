import { Component, OnInit } from '@angular/core';
import { MedicalStaff, MedicalRecordDTO, DiagnosticDTO, PrescriptionDTO, DosageDTO } from '../api/models';
import { Router, ActivatedRoute } from '@angular/router';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import * as moment from 'moment';
import { NgIf } from '@angular/common';

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
  prescription: string;
  checked: boolean;
  myvar: boolean;
  showDosage = false;
  beginDosage: string;
  endDosage: string;
  descriptionDosage: string;

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

        // Prescription
        if (this.prescription !== undefined) {
          const prescription: PrescriptionDTO = {
            title: this.diagnostic,
            body: this.prescription,
            medicalRecordId: this.idDmp,
            draft: false,
            creationDate: moment().locale('fr').format('L'),
            prescriptorId: this.me.idMedicalStaff,
            diagnosticId: JSON.parse(response.body)['idDiagnostic']
          };

          this.medicalService.createPrescriptionResponse(this.idDmp, prescription).subscribe(responsePrescription => {
            if (responsePrescription.status === 201) {
              console.log('Prescription ' + JSON.parse(responsePrescription.body)['idPrescription'] + ' crée');
            } else {
              console.log('Prescription non crée');
            }
          });
          }
        }

        // Posologie
        if (this.showDosage) {
          const dosage: DosageDTO = {
            beginDosage: this.beginDosage,
            endDosage: this.endDosage,
            body: this.descriptionDosage,
            creationDate: moment().locale('fr').format('L'),
            creatorId: this.me.idMedicalStaff,
            diagnosticId: JSON.parse(response.body)['idDiagnostic'],
            draft: false,
            medicalRecordId: this.idDmp,
            title: this.diagnostic,
          };

          this.medicalService.createDosageResponse(this.idDmp, dosage).subscribe(responseDosage => {
            if (responseDosage.status === 201) {
              console.log('Dosage ' + JSON.parse(responseDosage.body)['idDosage'] + ' crée');
            } else {
              console.log('Dosage non crée');
            }
          });
        }

        this.router.navigate(['/record/' + this.idDmp + '/diagnostics/' + JSON.parse(response.body)['idDiagnostic']]);
    });
  }
}
