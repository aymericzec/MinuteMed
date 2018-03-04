import { Component, OnInit } from '@angular/core';
import { MedicalStaff } from '../api/models';
import { StaffRESTEndpointService } from '../api/services/staff-restendpoint.service';
import * as $ from 'jquery';
import 'fullcalendar';
import 'fullcalendar/dist/fullcalendar.css';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  me: MedicalStaff;

  constructor(private staffService: StaffRESTEndpointService) { }

  ngOnInit() {
    this.staffService.getCurrentUserResponse().subscribe(
      response => {
        this.me = response.body;
    });
  }
}

$(function() {
  const containerEl: JQuery = $('#calendar');

  containerEl.fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,agendaWeek,agendaDay,listWeek'
    },
    defaultDate: '2018-01-12',
    navLinks: true, // can click day/week names to navigate views
    editable: true,
    eventLimit: true, // allow "more" link when too many events
    events: [
      {
        title: 'All Day Event',
        start: '2018-01-01',
      },
      {
        title: 'Long Event',
        start: '2018-01-07',
        end: '2018-01-10'
      },
      {
        id: 999,
        title: 'Repeating Event',
        start: '2018-01-09T16:00:00'
      },
      {
        id: 999,
        title: 'Repeating Event',
        start: '2018-01-16T16:00:00'
      },
      {
        title: 'Conference',
        start: '2018-01-11',
        end: '2018-01-13'
      },
      {
        title: 'Meeting',
        start: '2018-01-12T10:30:00',
        end: '2018-01-12T12:30:00'
      },
      {
        title: 'Lunch',
        start: '2018-01-12T12:00:00'
      },
      {
        title: 'Meeting',
        start: '2018-01-12T14:30:00'
      },
      {
        title: 'Happy Hour',
        start: '2018-01-12T17:30:00'
      },
      {
        title: 'Dinner',
        start: '2018-01-12T20:00:00'
      },
      {
        title: 'Birthday Party',
        start: '2018-01-13T07:00:00'
      },
      {
        title: 'Click for Google',
        url: 'http://google.com/',
        start: '2018-01-28'
      }
    ]
  });
});

