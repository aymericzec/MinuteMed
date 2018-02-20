import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration } from './api-configuration';

import { AuthenticationRESTEndpointService } from './services/authentication-restendpoint.service';
import { ArborescenceRESTEndpointService } from './services/arborescence-restendpoint.service';
import { MedicalRecordsRESTEndpointService } from './services/medical-records-restendpoint.service';
import { SpecializationsRESTEndpointService } from './services/specializations-restendpoint.service';
import { StaffRESTEndpointService } from './services/staff-restendpoint.service';

/**
 * Module that provides instances for all API services
 */
@NgModule({
  imports: [
    HttpClientModule
  ],
  exports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [
    ApiConfiguration,
   AuthenticationRESTEndpointService,
   ArborescenceRESTEndpointService,
   MedicalRecordsRESTEndpointService,
   SpecializationsRESTEndpointService,
   StaffRESTEndpointService
  ],
})
export class ApiModule { }
