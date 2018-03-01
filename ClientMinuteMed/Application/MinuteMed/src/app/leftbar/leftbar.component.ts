import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { MedicalStaff, MedicalRecord } from '../../apis/models';
import { StaffRESTEndpointService } from '../../apis/services/staff-restendpoint.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-leftbar',
  templateUrl: './leftbar.component.html',
  styleUrls: ['./leftbar.component.css']
})
export class LeftbarComponent implements OnInit {

  me: MedicalStaff;
  idMedical: number;

  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.idMedical = this.route.snapshot.params['id'];
    this.staffService.getMe().subscribe(
      response => {
        this.me = response.body;
    });
  }

}
