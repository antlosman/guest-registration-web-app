import { Component } from '@angular/core';
import { FormBuilder } from "@angular/forms";
import { EventFormService } from "../../services/event-form.service";
import { Event } from "../../models/event";

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent {

  constructor(private formBuilder: FormBuilder,
              private eventService: EventFormService ) { }

  eventForm = this.formBuilder.group({
    name: [''],
    date: [''],
    participantsQuantity: ['']
  })


  onFormSubmit() {
    console.log("On submitting whole post...")
    console.log(`Value from form: [${JSON.stringify(this.eventForm.value)}]`)

    let event: Event = {
      id: 0,
      name: this.eventForm.value.name,
      date: this.eventForm.value.date,
      participantsQuantity: this.eventForm.value.participantsQuantity
    }

    this.eventService.createNewEvent(event);

  }


}
