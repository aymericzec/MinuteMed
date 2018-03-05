import { Component, OnInit } from '@angular/core';
import { visitValue } from '@angular/compiler/src/util';
import { Router, RouterLink } from '@angular/router';
import { MedicalRecordDTO } from '../api/models';
import { MedicalRecordsRESTEndpointService } from '../api/services';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-searchdmp',
  templateUrl: './searchdmp.component.html',
  styleUrls: ['./searchdmp.component.css']
})
export class SearchDmpComponent implements OnInit {

  loading: boolean;

    records: MedicalRecordDTO[];

    cols: any[];

    constructor(private recordService: MedicalRecordsRESTEndpointService,
                private authService: AuthService) { }

    ngOnInit() {
        this.loading = true;

        setTimeout(() => {
            this.recordService.getAllMedicalRecordResponse(this.authService.jwt).subscribe(response => {
                this.records = response.body;
            });
            this.loading = false;
        }, 1000);

        this.cols = [
            { field: 'id', header: 'Identifiant' },
            { field: 'ss', header: 'Num sécu' },
            { field: 'firstName', header: 'Prenom' },
            { field: 'lastName', header: 'Nom' },
            { field: 'birthday', header: 'Date de naissance'},
            { field: 'gender', header: 'Genre' }
        ];
    }

}
