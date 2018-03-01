import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService } from '../../apis/services';
import { MedicalRecord } from '../../apis/models';

@Component({
  selector: 'app-createdmp',
  templateUrl: './createdmp.component.html',
  styleUrls: ['./createdmp.component.css']
})
export class CreatedmpComponent implements OnInit {
  mr: MedicalRecord;



  constructor(private medicalService: MedicalRecordsRESTEndpointService) { }

  ngOnInit() {

  }

  createDMP () {

  }
}
