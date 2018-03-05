import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';
import { PrescriptionDTO, Doctor, MedicalStaffDTO } from '../api/models';
import { MedicalRecordsRESTEndpointService, StaffRESTEndpointService } from '../api/services';

@Component({
  selector: 'app-consult-prescription',
  templateUrl: './consult-prescription.component.html',
  styleUrls: ['./consult-prescription.component.css']
})
export class ConsultPrescriptionComponent implements OnInit {

  prescriptions: PrescriptionDTO[];
  cols: any[];
  prescription: PrescriptionDTO;
  prescriptor: MedicalStaffDTO;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute,
    private staffService: StaffRESTEndpointService) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idPrescription = this.route.snapshot.params['idPrescription'];

    this.medicalService.getPrescription({'idRecord': idDmp, 'idPrescription': idPrescription}).subscribe(p => {
      this.prescription = p;

      this.staffService.getMedicalStaff(p.prescriptorId).subscribe(doctorResponse => {
        this.prescriptor = doctorResponse;
      });
    });
  }

}
