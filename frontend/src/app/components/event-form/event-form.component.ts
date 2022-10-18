import { Component } from '@angular/core';
import { FormBuilder, Validators } from "@angular/forms";
import { EventFormService } from "../../services/event-form.service";
import { Event } from "../../models/event";
import { Router } from "@angular/router";

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent {

  datePattern = "^\\d{4}-\\d{2}-\\d{2}$";
  isValidFormSubmitted = false;

  constructor(private formBuilder: FormBuilder,
              private eventService: EventFormService,
              private router: Router) { }

  eventForm = this.formBuilder.group({
    name: ['', [Validators.required, Validators.nullValidator]],
    date: ['', [Validators.required, Validators.pattern(this.datePattern)]],
    participantsQuantity: ['', [Validators.required, Validators.min(1)]]
  })


  onFormSubmit() {
    console.log("On submitting whole event...")
    console.log(`Value from form: [${JSON.stringify(this.eventForm.value)}]`)

    if (this.eventForm.invalid) {
      return;
    }

    this.isValidFormSubmitted = true;

    let event: Event = {
      id: 0,
      name: this.eventForm.value.name,
      date: this.eventForm.value.date,
      participantsQuantity: this.eventForm.value.participantsQuantity
    }

    this.eventService.createNewEvent(event);
    this.eventForm.reset();

    this.router.navigate(['homepage'])
      .then(() => {
        window.location.reload();
      });
  }

}
