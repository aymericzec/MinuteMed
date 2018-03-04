import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { MedicalRecordsRESTEndpointService } from '../../apis/services';
import { PrescriptionDTO } from '../../apis/models';

@Component({
  selector: 'app-consultprescription',
  templateUrl: './consultprescription.component.html',
  styleUrls: ['./consultprescription.component.css']
})
export class ConsultprescriptionComponent implements OnInit {
  prescriptions: PrescriptionDTO[];
  cols: any[];
  prescription: PrescriptionDTO;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idPrescription = this.route.snapshot.params['idPrescription'];

    this.medicalService.getPrescription({'idRecord': idDmp, 'idPrescription': idPrescription}).subscribe(p => {
      this.prescription = p;
    });
  }
}
