import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { MedicalStaff } from '../api/models';
import { StaffRESTEndpointService } from '../api/services/staff-restendpoint.service';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  me: MedicalStaff;


  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService) {

  }

  ngOnInit() {
    this.staffService.getCurrentUserResponse().subscribe(
      response => {
        this.me = response.body;
    });

  }

  logout() {
    this.authService.logout();
    console.log('logout');
  }

}
