import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { WelcomeComponent } from './components/welcome/welcome.component';
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FutureEventsComponent } from './components/future-events/future-events.component';
import {MatTableModule} from "@angular/material/table";
import {MatCardModule} from "@angular/material/card";
import {CdkTableModule} from "@angular/cdk/table";
import { HeaderComponent } from './components/header/header.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import { PastEventsComponent } from './components/past-events/past-events.component';
import { FooterComponent } from './components/footer/footer.component';
import { EventFormComponent } from './components/event-form/event-form.component';
import {MatButtonModule} from "@angular/material/button";
import {RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {path: 'homepage', component: HomeComponent},
  {path: 'add-event', component: EventFormComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  declarations: [
    WelcomeComponent,
    FutureEventsComponent,
    HeaderComponent,
    PastEventsComponent,
    FooterComponent,
    EventFormComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    CdkTableModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [WelcomeComponent]
})
export class AppModule { }
