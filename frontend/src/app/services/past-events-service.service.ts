import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable, tap} from "rxjs";
import {BACKEND_DELETE_EVENT_BY_ID, BACKEND_PAST_EVENTS} from "../constants/constant";
import {Event} from "../models/event";

@Injectable({
  providedIn: 'root'
})
export class PastEventsServiceService {

  constructor(private http: HttpClient) { }

  getPastEvents(): Observable<Array<Event>> {
    this.http.get<any>(BACKEND_PAST_EVENTS)
      .pipe(
        tap(value => console.log("Data before processing: " + JSON.stringify(value))),
        map((value: Array<any>) =>
          value.map(item =>
            <Event>{
              id: item.id,
              name: item.name,
              date: item.date,
              participantsQuantity: item.participantsQuantity
            })),
        tap(value => console.log("Data after processing: " + JSON.stringify(value)))
      ).subscribe();

    return this.http.get<Array<Event>>(BACKEND_PAST_EVENTS)
  }

  deleteEvent(id: number): Observable<void> {
    return this.http.delete<void>(`${BACKEND_DELETE_EVENT_BY_ID}/${id}`)
  }
}
