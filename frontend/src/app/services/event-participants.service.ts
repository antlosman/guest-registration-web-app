import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";
import {Event} from "../models/event";
import {PrivateClient} from "../models/privateClient";
import {BusinessClient} from "../models/businessClient";

import {
  BACKEND_CREATE_EVENT,
  BACKEND_CREATE_NEW_BUSINESS_CLIENT, BACKEND_DELETE_BUSINESS_CLIENT_BY_ID,
  BACKEND_DELETE_PRIVATE_CLIENT_BY_ID,
  BACKEND_GET_BUSINESS_CLIENT_BY_ID,
  BACKEND_GET_PRIVATE_CLIENT_BY_ID, PRIVATE_CLIENTS_URL, BACKEND_UPDATE_BUSINESS_CLIENT_BY_ID,
  BACKEND_UPDATE_PRIVATE_CLIENT_BY_ID, BUSINESS_CLIENTS_URL, BACKEND_CREATE_NEW_PRIVATE_CLIENT, BACKEND_FIND_EVENT_BY_ID
} from "../constants/constant";

@Injectable({
  providedIn: 'root'
})
export class EventParticipantsService {

  constructor(private http: HttpClient) { }


  getEventById(id: number): Observable<Event> {
    return this.http.get<Event>(BACKEND_FIND_EVENT_BY_ID + id)
      .pipe(
        tap(_ => console.log(`fetched event id=${id}`))
      )
  }

  createNewPrivateClient(newEvent: any): Observable<any> {
    let payload = {
      id: newEvent.id,
      name: newEvent.name,
      date: newEvent.date,
      participantsQuantity: newEvent.participantsQuantity
    }
    console.log(`Trying to send to backend new event: [${newEvent}] as payload [${JSON.stringify(payload)}`)

    return this.http.post(BACKEND_CREATE_NEW_PRIVATE_CLIENT, newEvent)
  }

  createNewBusinessClient(newEvent: any): Observable<any> {
    let payload = {
      id: newEvent.id,
      name: newEvent.name,
      date: newEvent.date,
      participantsQuantity: newEvent.participantsQuantity
    }
    console.log(`Trying to send to backend new event: [${newEvent}] as payload [${JSON.stringify(payload)}`)

    return this.http.post(BACKEND_CREATE_NEW_BUSINESS_CLIENT, newEvent)
  }

  mapping(newEvent: any, id: any): Observable<any> {
    let payload = {
      id: newEvent.id,
      name: newEvent.name,
      date: newEvent.date,
      participantsQuantity: newEvent.participantsQuantity
    }
    console.log(`Trying to send to backend new event: [${newEvent}] as payload [${JSON.stringify(payload)}`)

    return  this.http.put(BACKEND_CREATE_EVENT + newEvent + PRIVATE_CLIENTS_URL + id, {})
  }

  mappingBusinessClient(newEvent: any, id: any): Observable<any> {
    let payload = {
      id: newEvent.id,
      name: newEvent.name,
      date: newEvent.date,
      participantsQuantity: newEvent.participantsQuantity
    }
    console.log(`Trying to send to backend new event: [${newEvent}] as payload [${JSON.stringify(payload)}`)

    return  this.http.put(BACKEND_CREATE_EVENT + newEvent + BUSINESS_CLIENTS_URL +id, {})
  }

  getPrivateClientById(id: number): Observable<PrivateClient> {
    return this.http.get<PrivateClient>(`${BACKEND_GET_PRIVATE_CLIENT_BY_ID}/${id}`)
  }

  getBusinessClientByID(id: number): Observable<BusinessClient> {
    return this.http.get<BusinessClient>(`${BACKEND_GET_BUSINESS_CLIENT_BY_ID}/${id}`)
  }

  updatePrivateClient(id: number, privateClient: PrivateClient): Observable<any> {
    return this.http.put(`${BACKEND_UPDATE_PRIVATE_CLIENT_BY_ID}/${id}`, privateClient)
  }

  updateBusinessClient(id: number, businessClient: BusinessClient): Observable<any> {
    return this.http.put(`${BACKEND_UPDATE_BUSINESS_CLIENT_BY_ID}/${id}`, businessClient)
  }

  deletePrivateClient(id: number): Observable<void> {
    return this.http.delete<void>(`${BACKEND_DELETE_PRIVATE_CLIENT_BY_ID}/${id}`)
  }

  deleteBusinessClient(id: number): Observable<void> {
    return this.http.delete<void>(`${BACKEND_DELETE_BUSINESS_CLIENT_BY_ID}/${id}`)
  }



}
