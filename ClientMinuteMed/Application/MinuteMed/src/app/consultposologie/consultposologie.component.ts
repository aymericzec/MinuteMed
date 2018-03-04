import { Component, OnInit } from '@angular/core';
import { DosageDTO } from '../api/models';
import { MedicalRecordsRESTEndpointService } from '../api/services';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-consultposologie',
  templateUrl: './consultposologie.component.html',
  styleUrls: ['./consultposologie.component.css']
})
export class ConsultposologieComponent implements OnInit {
  dosages: DosageDTO[];
  cols: any[];
  dosage: DosageDTO;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const idDosage = this.route.snapshot.params['idPosologie'];

    this.medicalService.getDosage({'idRecord': idDmp, 'idDosage': idDosage}).subscribe(e => {
      this.dosage = e;
    });
  }

}
