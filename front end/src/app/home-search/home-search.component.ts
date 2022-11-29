import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { tap } from 'rxjs';

@Component({
  selector: 'app-home-search',
  templateUrl: './home-search.component.html',
  styleUrls: ['./home-search.component.css']
})
export class HomeSearchComponent implements OnInit {

  homeApiUrl : string = 'http://localhost:8080/api/home/';
  home_id : string = '';
  homeData !: any;
  foundHome : boolean = false;

  constructor( private http: HttpClient) {}

  ngOnInit(): void {
  }

  searchHome(){
    this.getHome(this.home_id);
  }

  getHome(homeId : string){
    this.http.get<any>(this.homeApiUrl + homeId)
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
