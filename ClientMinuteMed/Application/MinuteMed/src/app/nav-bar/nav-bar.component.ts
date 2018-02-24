import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { MedicalStaff } from '../../apis/models';
import { StaffRESTEndpointService } from '../../apis/services/staff-restendpoint.service';


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
    this.staffService.getMe(this.authService).subscribe(
      response => {          
        this.me = response.body;
    });

  }



  logout() {
    this.authService.logout();
  }

}
