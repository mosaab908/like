import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HomeSearchComponent } from './home-search/home-search.component';
import { FormsModule } from '@angular/forms';
import { HomeListComponent } from './home-list/home-list.component';
import { HomeRegisterComponent } from './home-register/home-register.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HomeSearchComponent,
    HomeListComponent,
    HomeRegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
