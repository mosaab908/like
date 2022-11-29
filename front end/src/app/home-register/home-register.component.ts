import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HomeService } from '../services/home.service';


@Component({
  selector: 'app-home-register',
  templateUrl: './home-register.component.html',
  styleUrls: ['./home-register.component.css']
})
export class HomeRegisterComponent implements OnInit {
  
  homeApiUrl : string = 'http://localhost:8080/api/home/';

  constructor(private http : HttpClient) { }

  foundRegister : boolean = false;

  ngOnInit(): void {

 
  }

  showForm(){
    this.foundRegister = true;
  }
  onHomeCreate(homes: {name_home: string, size_home: number, cost_home: number}){
      console.log(homes);
      this.http.post<any>(`${this.homeApiUrl}register`,homes)
      .subscribe((res) => {
        console.log(res);
      });
      alert("home was registred");
      this.foundRegister= false;
      
  }
  
  /*onSubmit(): void {
    this.homeService.register(this.registerForm.get('name_home')?.value, this.registerForm.get('size_home')?.value, this.registerForm.get('cost_home')?.value).subscribe(
      () => console.log("New home registered"),
      (err: any) => console.log(err)
      //() => this.router.navigate(['login'])
    );
  }*/



}
