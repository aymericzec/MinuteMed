import { Component, OnInit } from '@angular/core';
import { MedicalRecordsRESTEndpointService, ArborescenceRESTEndpointService, StaffRESTEndpointService } from '../api/services';
import { MedicalRecordDTO, MedicalStaff, NodeDTO } from '../api/models';
import {TreeNode} from 'primeng/api';

@Component({
  selector: 'app-createdmp',
  templateUrl: './createdmp.component.html',
  styleUrls: ['./createdmp.component.css']
})
export class CreatedmpComponent implements OnInit {

  record: MedicalRecordDTO;
  me: MedicalStaff;
  today = Date.now();

  tree: TreeNode[];

  ss: string;
  firstName: string;
  lastName: string;
  address: string;
  cityBorn: string;
  birthday: string;
  gender: string;
  phoneNumber: string;
  email: string;
  selectedTreeNode: TreeNode;

  constructor(private medicalService: MedicalRecordsRESTEndpointService,
    private arborescenceService: ArborescenceRESTEndpointService,
    private staffService: StaffRESTEndpointService) {}


    private static nodeDTOtoTreeNode(node: NodeDTO): TreeNode {
      return  {
        label: node.name,
        data: node,
        icon: 'fas fa-stethoscope',
        selectable: (node.floor === 'CARE_UNIT'),
        children: node.childrens.map(CreatedmpComponent.nodeDTOtoTreeNode)
      };
    }

  ngOnInit() {

    this.staffService.getCurrentUserResponse().subscribe(
      response => {
        this.me = response.body;
    });

    this.arborescenceService.getCurrentNode().subscribe(
      node => {
        this.tree = [CreatedmpComponent.nodeDTOtoTreeNode(node)];
    });

  }


  createDMP () {
      this.medicalService.createMedicalRecordResponse({
      ss: this.ss,
      firstName: this.firstName,
      lastName: this.lastName,
      address: this.address,
      cityBorn: this.cityBorn,
      birthday: this.birthday,
      gender: this.gender,
      phoneNumber: this.phoneNumber,
      email: this.email,
      careUnit: this.selectedTreeNode.data
    }).subscribe(resp => {console.log('response status : ', resp.status); });
  }



}

