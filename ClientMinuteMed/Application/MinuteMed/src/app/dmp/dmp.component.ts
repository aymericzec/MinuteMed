import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicalRecordDTO } from '../api/models';
import { MedicalRecordsRESTEndpointService } from '../api/services';

@Component({
  selector: 'app-dmp',
  templateUrl: './dmp.component.html',
  styleUrls: ['./dmp.component.css']
})
export class DmpComponent implements OnInit {

  private record: MedicalRecordDTO;

  constructor(private recordService: MedicalRecordsRESTEndpointService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.initMedicalRecord();
  }

  initMedicalRecord(): void {
    const id = this.route.snapshot.params['id'];
    this.recordService.getMedicalRecord(id).subscribe(record => {
      this.record = record;
    });
  }

}
