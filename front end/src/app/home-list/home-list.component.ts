import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { tap } from 'rxjs';

@Component({
  selector: 'app-home-list',
  templateUrl: './home-list.component.html',
  styleUrls: ['./home-list.component.css']
})
export class HomeListComponent implements OnInit {

  @Input()
  homeListData !: any;

  homeApiUrl : string = 'http://localhost:8080/api/home/';
  home_id : string = '';
  homeData !: any;
  foundHome : boolean = false;
  
  constructor(private http : HttpClient) { }

  ngOnInit(): void {
    this.getHome()
  }

  getHome(){
    this.http.get<any>(this.homeApiUrl )
      .pipe(
        tap((val: any) => console.log(val))
      )
      .subscribe(data =>{
        this.homeData = data;
        console.log(this.homeData);
        this.foundHome = true;
      });
  }

}
