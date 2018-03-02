import { Component, OnInit } from '@angular/core';
import { Dosage } from '../../apis/models';
import { MedicalRecordsRESTEndpointService } from '../../apis/services';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-consultposologie',
  templateUrl: './consultposologie.component.html',
  styleUrls: ['./consultposologie.component.css']
})
export class ConsultposologieComponent implements OnInit {
  dosages: Dosage[];
  cols: any[];
  dosage: Dosage;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private authService: AuthService, private route: ActivatedRoute) { }

  ngOnInit() {
    const idDmp = this.route.snapshot.params['id'];
    const iddosage = this.route.snapshot.params['idPosologie'];

    class Test implements MedicalRecordsRESTEndpointService.GetDosageParams {
      idRecord: number;
      idDosage: number;

      constructor(idRecord: number, idDosage: number) {
        this.idDosage = idDosage;
        this.idRecord = idRecord;
      }
    }

    const lolo = new Test(idDmp, iddosage);

    this.medicalService.getDosage(lolo).subscribe(e => {
      this.dosage = e;
    });
  }

}
