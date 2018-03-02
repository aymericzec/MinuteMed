import { Component, OnInit } from '@angular/core';
import { MedicalStaff, MedicalRecord, Exam, ResultExam, Doctor } from '../../apis/models';
import { AuthService } from '../auth.service';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService, ArborescenceRESTEndpointService } from '../../apis/services';
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
  title: string;
  description: string;
  dateToday: string;

  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private medicalService: MedicalRecordsRESTEndpointService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.idDmp = this.route.snapshot.params['id'];

    this.staffService.getMe().subscribe(
      response => {
        this.me = response.body;
    });

    this.medicalService.getMedicalRecord(this.idDmp).subscribe(
      response => {
        this.md = response;
    });

    this.today = new Date();
  }

  onSubmitCreate() {
    console.log('Salut ' + this.idDmp);
    class ExamImpl implements Exam {
      idExam?: number;
      medicalRecord: MedicalRecord;
      title: string;
      description: string;
      dateExam: string;
      resultExam: ResultExam;
      draft: boolean;
      doctor?: Doctor;
      constructor(mr: MedicalRecord, title: string, description: string, dateExam: string, draft: boolean, doctor: Doctor) {
        this.medicalRecord = mr;
        this.title = title;
        this.description = description;
        this.dateExam = dateExam;
        this.draft = draft;
        this.doctor = doctor;
      }
    }

    console.log(this.dateToday);
    const e = new ExamImpl(this.md, this.title, this.description, '12/03/2017', false, this.me);

    console.log(e);
    this.medicalService.createExam(this.idDmp, e).subscribe();
  }

}
