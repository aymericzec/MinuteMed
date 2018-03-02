import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicalRecord } from '../../apis/models';
import { MedicalRecordsRESTEndpointService } from '../../apis/services';

@Component({
  selector: 'app-dmp',
  templateUrl: './dmp.component.html',
  styleUrls: ['./dmp.component.css']
})
export class DmpComponent implements OnInit {

  private record: MedicalRecord;

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
