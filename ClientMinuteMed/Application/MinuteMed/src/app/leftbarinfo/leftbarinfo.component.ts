import { Component, OnInit } from '@angular/core';
import { MedicalStaff } from '../api/models';
import { StaffRESTEndpointService } from '../api/services';

@Component({
  selector: 'app-leftbarinfo',
  templateUrl: './leftbarinfo.component.html',
  styleUrls: ['./leftbarinfo.component.css']
})
export class LeftbarinfoComponent implements OnInit {

  me: MedicalStaff;

  constructor(private staffService: StaffRESTEndpointService) { }

  ngOnInit() {
    this.staffService.getCurrentUserResponse().subscribe(
      response => {
        this.me = response.body;
    });

}
