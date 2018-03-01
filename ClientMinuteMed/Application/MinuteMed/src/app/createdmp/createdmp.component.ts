import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService } from '../../apis/services';
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

  constructor(private medicalService: MedicalRecordsRESTEndpointService) { }

  ngOnInit() {

  }

  createDMP () {
    // this.medicalService.createMedicalRecord();
  }

}
