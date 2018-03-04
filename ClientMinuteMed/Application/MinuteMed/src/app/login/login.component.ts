import { Component, OnInit, Inject, NgModule } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationRESTEndpointService } from '../api/services/authentication-restendpoint.service';
import { HttpResponse } from '@angular/common/http';

import {AuthService} from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  title = 'Login';
  mdUserName: string;
  mdPassword: string;

  ngOnInit() {
  }

  constructor(private router: Router,
    private route: ActivatedRoute,
    private authServiceEndpoint: AuthenticationRESTEndpointService,
    private authService: AuthService ) {
  }


  onSubmit() {
    this.authServiceEndpoint
      .authenticateUserResponse({password: this.mdPassword, login: this.mdUserName })
      .subscribe(response => {
        this.authService.login(response.headers.get('Authorization'));
        if (this.authService.isLoggedIn()) {
          this.router.navigate(['/home']);
        }
      });
    }

  }

