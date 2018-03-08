import { Component, OnInit } from '@angular/core';
import { DosageDTO, Doctor, MedicalStaffDTO, DosageReportDTO, MedicalStaff } from '../api/models';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';

@Component({
  selector: 'app-consult-dosage',
  templateUrl: './consult-dosage.component.html',
  styleUrls: ['./consult-dosage.component.css']
})
export class ConsultDosageComponent implements OnInit {

  dosages: DosageDTO[];
  cols: any[];
  dosage: DosageDTO;
  doctorCreator: MedicalStaffDTO;
  reportsDosage: DosageReportDTO[];
  bodyReport: string;
  currentStaff: MedicalStaff;
  idDmp: number;
  lastAdministration: string;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute,
    private staffService: StaffRESTEndpointService) { }

  ngOnInit() {
    this.idDmp = this.route.snapshot.params['id'];
    const idDosage = this.route.snapshot.params['idPosologie'];

    this.medicalService.getDosage({'idRecord': this.idDmp, 'idDosage': idDosage}).subscribe(e => {
      this.dosage = e;

      this.reportsDosage = this.dosage.reports;

      this.sortDate();

      if (this.reportsDosage.length > 0) {
        this.lastAdministration = this.reportsDosage[0].creationDate;
      } else {
        this.lastAdministration = 'Aucune Administration';
      }

      this.staffService.getMedicalStaff(this.dosage.creatorId).subscribe(responseDoctor => {
        this.doctorCreator = responseDoctor;
      });
    });

    this.staffService.getCurrentUser().subscribe(x => {
      this.currentStaff = x;
    });
  }

  addRapport() {
    const medicalDTO: MedicalStaffDTO = {
      id: this.currentStaff.idMedicalStaff,
      lastname: this.currentStaff.lastName,
      firstname: this.currentStaff.firstName,
      idNode: this.currentStaff.node.idNode,
      status: this.currentStaff.status
    };

    const reportDosage: DosageReportDTO = {
      body: this.bodyReport,
      creationDate: moment().locale('fr').format('MM/DD/YYYY à HH:mm'),
      dosageId: this.dosage.id,
      supervisor: medicalDTO
    };

    console.log(reportDosage);

    this.medicalService.createReportDosageResponse(this.idDmp, reportDosage).subscribe(x => {
      if (x.status === 201) {
        this.reportsDosage.push(reportDosage);
        this.lastAdministration = reportDosage.creationDate;
        this.sortDate();
        console.log('Rapport crée');
      } else {
        console.log('Rapport non crée, problème');
      }
    });
  }

  private sortDate () {
    this.reportsDosage.sort((a, b) => {
      if (a.creationDate <= b.creationDate) {
        return 1;
      } else {
        return -1;
      }
    });
  }
}
