import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Event} from "../models/event";
import {BACKEND_CREATE_EVENT} from "../constants/constant";

@Injectable({
  providedIn: 'root'
})
export class EventFormService {

  constructor(private http: HttpClient) { }

  createNewEvent(newEvent: Event) {
    let payload = {
      id: newEvent.id,
      name: newEvent.name,
      date: newEvent.date,
      participantsQuantity: newEvent.participantsQuantity
    }
    console.log(`Trying to send to backend new event: [${newEvent}] as payload [${JSON.stringify(payload)}`)
    this.http.post(BACKEND_CREATE_EVENT, payload).subscribe()
  }

}
