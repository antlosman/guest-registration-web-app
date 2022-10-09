import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";
import {Event} from "../models/event";
import {PrivateClient} from "../models/privateClient";
import {
  BACKEND_CREATE_EVENT, BACKEND_DELETE_PRIVATE_CLIENT_BY_ID,
  BACKEND_GET_PRIVATE_CLIENT_BY_ID,
  BACKEND_UPDATE_PRIVATE_CLIENT_BY_ID
} from "../constants/constant";

@Injectable({
  providedIn: 'root'
})
export class EventParticipantsService {

  constructor(private http: HttpClient) { }


  getEventById(id: number): Observable<Event> {
    return this.http.get<Event>('http://localhost:8080/events/findEventById/' + id)
      .pipe(
        tap(_ => console.log(`fetched event id=${id}`))
      )
  }
  // todo: code cleaning
  createNewPrivateClient(newEvent: any): Observable<any> {
    // let payload = {
    //   id: newEvent.id,
    //   name: newEvent.name,
    //   date: newEvent.date,
    //   participantsQuantity: newEvent.participantsQuantity
    // }
   // console.log(`Trying to send to backend new event: [${newEvent}] as payload [${JSON.stringify(payload)}`)

    return this.http.post("http://localhost:8080/events/private-client", newEvent)
  }

  mapping(newEvent: any, id: any): Observable<any> {
    // let payload = {
    //   id: newEvent.id,
    //   name: newEvent.name,
    //   date: newEvent.date,
    //   participantsQuantity: newEvent.participantsQuantity
    // }
    // console.log(`Trying to send to backend new event: [${newEvent}] as payload [${JSON.stringify(payload)}`)

    return  this.http.put("http://localhost:8080/events/"+ newEvent +"/private-clients/"+id, {})
  }

  getPrivateClientById(id: number): Observable<PrivateClient> {
    return this.http.get<PrivateClient>(`${BACKEND_GET_PRIVATE_CLIENT_BY_ID}/${id}`)
  }

  updatePrivateClient(id: number, privateClient: PrivateClient): Observable<any> {
    return this.http.put(`${BACKEND_UPDATE_PRIVATE_CLIENT_BY_ID}/${id}`, privateClient)
  }

  deletePrivateClient(id: number): Observable<void> {
    return this.http.delete<void>(`${BACKEND_DELETE_PRIVATE_CLIENT_BY_ID}/${id}`)
  }

}
