import { Component, OnInit } from '@angular/core';
import { visitValue } from '@angular/compiler/src/util';
import { RouterLink } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dmp',
  templateUrl: './dmp.component.html',
  styleUrls: ['./dmp.component.css']
})
export class DmpComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  clickGoogle () {
    console.log('Salut je rentre');
    this.router.navigate(['/login']);
  }

}
