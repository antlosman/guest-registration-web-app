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

  displayedColumns: string[] = ['id', 'name', 'date', 'participants'];
  groupedColumns: string[] = ['grouped'];

}
