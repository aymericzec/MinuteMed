import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService, ArborescenceRESTEndpointService, StaffRESTEndpointService } from '../../apis/services';
import { MedicalRecordDTO, MedicalStaff } from '../../apis/models';

@Component({
  selector: 'app-createdmp',
  templateUrl: './createdmp.component.html',
  styleUrls: ['./createdmp.component.css']
})
export class CreatedmpComponent implements OnInit {

  record: MedicalRecordDTO;
  me: MedicalStaff;
  today = Date.now();

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
  private hospitalService: ArborescenceRESTEndpointService,
  private staffService: StaffRESTEndpointService) { }

  ngOnInit() {

    this.staffService.getMe().subscribe(
      response => {
        this.me = response.body;
    });



  }

  createDMP () {
    // this.medicalService.createMedicalRecord();
  }

}
