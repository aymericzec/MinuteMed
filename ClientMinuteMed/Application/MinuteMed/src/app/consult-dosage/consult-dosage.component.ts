import { Component, OnInit } from '@angular/core';
import { DosageDTO, Doctor, MedicalStaffDTO } from '../api/models';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';

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

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute,
    private staffService: StaffRESTEndpointService) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idDosage = this.route.snapshot.params['idPosologie'];

    this.medicalService.getDosage({'idRecord': idDmp, 'idDosage': idDosage}).subscribe(e => {
      this.dosage = e;

      this.staffService.getMedicalStaff(this.dosage.creatorId).subscribe(responseDoctor => {
        this.doctorCreator = responseDoctor;
      });
    });
  }

}
