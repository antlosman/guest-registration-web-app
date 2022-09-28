import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";
import {Event} from "../models/event";

@Injectable({
  providedIn: 'root'
})
export class EventParticipantsService {

  constructor(private http: HttpClient) { }


  getEventById(id: number | undefined): Observable<Event> {
    return this.http.get<Event>('http://localhost:8080/events/findEventById/' + id)
      .pipe(
        tap(_ => console.log(`fetched event id=${id}`))
      )
  }


}
