import { Component, OnInit } from '@angular/core';
import { visitValue } from '@angular/compiler/src/util';
import { RouterLink } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-searchdmp',
  templateUrl: './searchdmp.component.html',
  styleUrls: ['./searchdmp.component.css']
})
export class SearchDmpComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  clickGoogle () {
    console.log('Salut je rentre');
    this.router.navigate(['/login']);
  }

}
