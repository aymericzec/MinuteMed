import { Component, OnInit, Inject, NgModule } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationRESTEndpointService } from '../../apis/services/authentication-restendpoint.service';
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
    console.log('submit : ' + this.mdUserName + ', ' + this.mdPassword);
    this.authServiceEndpoint
      .authenticateUserResponse({password: this.mdPassword, login: this.mdUserName })
      .subscribe(response => {
        response.headers.getAll('authorization');
        this.authService.login(response.headers.get('authorization'));
        if (this.authService.isLoggedIn) {
          this.router.navigate(['/']);
        }
      });
      /*
      .mergeMap(jwt => this.route.queryParams)
      .map(qp => qp['redirectTo'])
      .subscribe(redirectTo => {
        if (this.authService.isLoggedIn) {
          const url = redirectTo ? [redirectTo] : ['/'];
          this.router.navigate(url);
        }
      });*/
    }

  }
