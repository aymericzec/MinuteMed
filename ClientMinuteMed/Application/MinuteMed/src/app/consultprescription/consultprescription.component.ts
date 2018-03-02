import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { MedicalRecordsRESTEndpointService } from '../../apis/services';
import { Prescription } from '../../apis/models';

@Component({
  selector: 'app-consultprescription',
  templateUrl: './consultprescription.component.html',
  styleUrls: ['./consultprescription.component.css']
})
export class ConsultprescriptionComponent implements OnInit {
  prescriptions: Prescription[];
  cols: any[];
  prescription: Prescription;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idPrescription = this.route.snapshot.params['idPrescription'];

    class Test implements MedicalRecordsRESTEndpointService.GetPrescriptionParams {
      idRecord: number;
      idPrescription: number;

      constructor(idRecord: number, idPrescript: number) {
        this.idPrescription = idPrescript;
        this.idRecord = idRecord;
      }
    }

    const lolo = new Test(idDmp, idPrescription);

    this.medicalService.getPrescription(lolo).subscribe(p => {
      this.prescription = p;
    });
  }
}
