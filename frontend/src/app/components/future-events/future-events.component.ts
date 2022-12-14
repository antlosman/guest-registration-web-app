import { Component, OnInit } from '@angular/core';
import { FutureEventsService } from "../../services/future-events.service";
import { Event } from "../../models/event";


@Component({
  selector: 'app-future-events',
  templateUrl: './future-events.component.html',
  styleUrls: ['./future-events.component.css']
})
export class FutureEventsComponent implements OnInit {

  futureEvents: Array<Event> = []

  constructor(private futureEventsService: FutureEventsService) { }

  ngOnInit(): void {
    this.futureEventsService
      .getFutureEvents()
      .subscribe(value => {this.futureEvents = value});
  }

  displayedColumns: string[] = ['id', 'name', 'date', 'participants', "actions"];
  groupedColumns: string[] = ['grouped'];

  onDeletePrivateClient(id: any) {
    console.log("id", id)
    this.futureEventsService.deleteEvent(id).subscribe(_value => {this.ngOnInit()});
  }
}
