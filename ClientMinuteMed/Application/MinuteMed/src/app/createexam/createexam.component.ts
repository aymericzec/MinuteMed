import { Component, OnInit } from '@angular/core';
import { MedicalStaff, MedicalRecordDTO, ExamDTO, ResultExamDTO, Doctor } from '../api/models';
import { AuthService } from '../auth.service';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService, ArborescenceRESTEndpointService } from '../api/services';
import { RouterLinkActive, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-createexam',
  templateUrl: './createexam.component.html',
  styleUrls: ['./createexam.component.css']
})
export class CreateexamComponent implements OnInit {

  me: MedicalStaff;
  today = Date.now();
  md: MedicalRecordDTO;
  idDmp: number;
  title: string;
  description: string;
  dateToday: string;

  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private medicalService: MedicalRecordsRESTEndpointService,
    private route: ActivatedRoute) {}

  ngOnInit() {
    this.idDmp = this.route.snapshot.params['id'];

    this.staffService.getCurrentUserResponse().subscribe(
      response => {
        this.me = response.body;
    });

    this.medicalService.getMedicalRecord(this.idDmp).subscribe(
      response => {
        this.md = response;
    });
  }

  onSubmitCreate() {
    const exam: ExamDTO = {'medicalRecordId' : this.md.id,
        'title': this.title,
        'description': this.description,
        'dateExam': this.today.toString(), // TODO: formatter les dates
        'draft': false,
        'doctorId': this.me.idMedicalStaff
      };

    console.log(exam);
    //this.medicalService.createExam(this.idDmp, exam).subscribe( __ => {console.log('Exam created with success !'); });
  }

}
