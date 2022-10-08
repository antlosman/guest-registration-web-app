import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable, tap} from "rxjs";
import {
  BACKEND_DELETE_EVENT_BY_ID,
  BACKEND_DELETE_PRIVATE_CLIENT_BY_ID,
  BACKEND_FUTURE_EVENTS
} from "../constants/constant";
import {Event} from "src/app/models/event";

@Injectable({
  providedIn: 'root'
})
export class FutureEventsService {

  constructor(private http: HttpClient) { }

  getFutureEvents(): Observable<Array<Event>> {
    this.http.get<any>(BACKEND_FUTURE_EVENTS)
      .pipe(
        tap(value => console.log("Data before processing: " + JSON.stringify(value))),
        map((value: Array<any>) =>
          value.map(item =>
            <Event> {
              id: item.id,
              name: item.name,
              date: item.date,
              participantsQuantity: item.participantsQuantity
            })),
        tap(value => console.log("Data after processing: " + JSON.stringify(value)))
      ).subscribe();

    return this.http.get<Array<Event>>(BACKEND_FUTURE_EVENTS)
  }

  deleteEvent(id: number): Observable<void> {
    return this.http.delete<void>(`${BACKEND_DELETE_EVENT_BY_ID}/${id}`)
  }
}
