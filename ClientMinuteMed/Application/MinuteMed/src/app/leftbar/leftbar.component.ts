import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { MedicalStaff } from '../../apis/models';
import { StaffRESTEndpointService } from '../../apis/services/staff-restendpoint.service';


@Component({
  selector: 'app-leftbar',
  templateUrl: './leftbar.component.html',
  styleUrls: ['./leftbar.component.css']
})
export class LeftbarComponent implements OnInit {

  me: MedicalStaff;


  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService) {

  }

  ngOnInit() {
    this.staffService.getMe().subscribe(
      response => {
        this.me = response.body;
    });
  }

}
