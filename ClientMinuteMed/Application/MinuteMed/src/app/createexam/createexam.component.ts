import { Component, OnInit } from '@angular/core';
import { MedicalStaff, MedicalRecordDTO, ExamDTO, ResultExamDTO, Doctor } from '../api/models';
import { AuthService } from '../auth.service';
import { StaffRESTEndpointService, MedicalRecordsRESTEndpointService, ArborescenceRESTEndpointService } from '../api/services';
import { RouterLinkActive, ActivatedRoute, Router } from '@angular/router';

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
  test: string;

  constructor(private authService: AuthService,
    private staffService: StaffRESTEndpointService,
    private medicalService: MedicalRecordsRESTEndpointService,
    private route: ActivatedRoute,
    private router: Router) {}

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
        'dateExam': this.today.toString(),
        'draft': false,
        'doctorId': this.me.idMedicalStaff
      };

    this.medicalService.createExamResponse(this.idDmp, exam).subscribe( response => {
      if (response.status === 201) {
        this.router.navigate(['/record/' + 1 + '/exams/' + JSON.parse(response.body)['idExam']]);
      }
    });
  }

}
