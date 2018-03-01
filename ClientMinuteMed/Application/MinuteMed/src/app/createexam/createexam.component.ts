import { Component, OnInit } from '@angular/core';
import { MedicalStaff, MedicalRecord, Exam } from '../../apis/models';
import { AuthService } from '../auth.service';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService } from '../../apis/services';
import { RouterLinkActive, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-createexam',
  templateUrl: './createexam.component.html',
  styleUrls: ['./createexam.component.css']
})
export class CreateexamComponent implements OnInit {

  me: MedicalStaff;
  today: Date;
  md: MedicalRecord;
  idDmp: number;

  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private medicalService: MedicalRecordsRESTEndpointService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.staffService.getMe().subscribe(
      response => {
        this.me = response.body;
    });

    this.medicalService.getMedicalRecord(2).subscribe(
      response => {
        this.md = response;
    });

    this.today = new Date();

    this.idDmp = this.route.snapshot.params['id'];
  }

  onSubmitCreate() {
    console.log('Salut ' + this.idDmp);
    this.medicalService.createExam(this.idDmp);
  }

}
