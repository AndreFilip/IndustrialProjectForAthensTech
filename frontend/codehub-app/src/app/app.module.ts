import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
// import {AppService} from "./app.service";


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    // LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  // providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
