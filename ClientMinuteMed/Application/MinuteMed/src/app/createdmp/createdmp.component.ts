import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService, ArborescenceRESTEndpointService, StaffRESTEndpointService } from '../../apis/services';
import { MedicalRecord, MedicalStaff } from '../../apis/models';

@Component({
  selector: 'app-createdmp',
  templateUrl: './createdmp.component.html',
  styleUrls: ['./createdmp.component.css']
})
export class CreatedmpComponent implements OnInit {

  record: MedicalRecord;
  me: MedicalStaff;
  today = Date.now();

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
  private hospitalService: ArborescenceRESTEndpointService,
  private staffService: StaffRESTEndpointService) { }

  ngOnInit() {

    this.staffService.getMe().subscribe(
      response => {
        this.me = response.body;

        class ParamsUnits implements ArborescenceRESTEndpointService.GetCareUnitsParams {
          idService: number;
          idPole: number;
          idHospital: number;
          idHU: number;
          idCU: number;
          idAPHP: number;

          constructor(idService: number, idPole: number,  idHospital: number, idHU: number, idCU: number, idAPHP: number) {
            this.idService = idService;
            this.idPole = idPole;
            this.idHospital = idHospital;
            this.idHU = idHU;
            this.idCU = idCU;
            this.idAPHP = idAPHP;
          }
        }

        const lolo = new ParamsUnits(1, 1, 1, 1, 1, 1);
/*
        this.hospitalService.getCareUnitsResponse(lolo).subscribe(x => {
          console.log(x.body);
        });*/
    });



  }

  createDMP () {
    // this.medicalService.createMedicalRecord();
  }

}
