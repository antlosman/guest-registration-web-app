import { Component, OnInit } from '@angular/core';
import {FutureEventsService} from "../../services/future-events.service";
import {Event} from "../../models/event";


@Component({
  selector: 'app-past-events',
  templateUrl: './past-events.component.html',
  styleUrls: ['./past-events.component.css']
})
export class PastEventsComponent implements OnInit {

  futureEvents: Array<Event> = []

  constructor(private futureEventsService: FutureEventsService) { }

  ngOnInit(): void {
    this.futureEventsService
      .getFutureEvents()
      .subscribe(value => {this.futureEvents = value});
  }

  displayedColumns: string[] = ['id', 'name', 'date', 'p-quantity'];
  groupedColumns: string[] = ['grouped'];

}
