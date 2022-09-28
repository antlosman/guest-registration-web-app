import { Component, OnInit } from '@angular/core';
import { EventParticipantsService } from "../../services/event-participants.service";
import { Event } from "../../models/event";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-participants',
  templateUrl: './participants.component.html',
  styleUrls: ['./participants.component.css']
})
export class ParticipantsComponent implements OnInit {


  eventId: any;
  event: Event | undefined;

  constructor(
    private route: ActivatedRoute,
    private eventParticipantsService: EventParticipantsService,
  ) {
  }

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
