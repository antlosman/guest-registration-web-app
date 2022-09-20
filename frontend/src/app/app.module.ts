import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { WelcomeComponent } from './components/welcome/welcome.component';
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FutureEventsComponent } from './components/future-events/future-events.component';
import {MatTableModule} from "@angular/material/table";
import {MatCardModule} from "@angular/material/card";
import {CdkTableModule} from "@angular/cdk/table";

@NgModule({
  declarations: [
    WelcomeComponent,
    FutureEventsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    CdkTableModule
  ],
  providers: [],
  bootstrap: [WelcomeComponent]
})
export class AppModule { }
