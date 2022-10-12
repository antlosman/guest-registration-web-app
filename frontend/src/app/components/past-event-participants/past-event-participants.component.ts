import { Component, OnInit } from '@angular/core';
import { EventParticipantsService } from "../../services/event-participants.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-past-event-participants',
  templateUrl: './past-event-participants.component.html',
  styleUrls: ['./past-event-participants.component.css']
})
export class PastEventParticipantsComponent implements OnInit {

  eventId: any;
  event: any;

  constructor(
    private route: ActivatedRoute,
    private eventParticipantsService: EventParticipantsService
  ) { }

  ngOnInit(): void {
    this.eventId = this.route.snapshot.params['id']
    this.getEventByID();
  }

  getEventByID() {
    this.eventParticipantsService.getEventById(this.eventId).subscribe( data =>
    {
      this.event = data;
      console.log(this.event)
    })
  }

}
