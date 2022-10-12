import { Component, OnInit } from '@angular/core';
import {PastEventsServiceService} from "../../services/past-events-service.service";
import {Event} from "../../models/event";


@Component({
  selector: 'app-past-events',
  templateUrl: './past-events.component.html',
  styleUrls: ['./past-events.component.css']
})
export class PastEventsComponent implements OnInit {

  futureEvents: Array<Event> = []

  constructor(private pastEventService: PastEventsServiceService) { }

  ngOnInit(): void {
    this.pastEventService
      .getPastEvents()
      .subscribe(value => {this.futureEvents = value});
  }

  displayedColumns: string[] = ['id', 'name', 'date', 'participants', "actions"];
  groupedColumns: string[] = ['grouped'];

  onDeletePrivateClient(id: any) {
    console.log("id", id)
    this.pastEventService.deleteEvent(id).subscribe(_value => {this.ngOnInit()});
  }

}
