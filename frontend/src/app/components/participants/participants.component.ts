import { Component, OnInit } from '@angular/core';
import { EventParticipantsService } from "../../services/event-participants.service";
import { Event } from "../../models/event";
import {ActivatedRoute} from "@angular/router";
import {PrivateClient} from "../../models/privateClient";
import {FormBuilder} from "@angular/forms";
import {EventFormService} from "../../services/event-form.service";


@Component({
  selector: 'app-participants',
  templateUrl: './participants.component.html',
  styleUrls: ['./participants.component.css']
})
export class ParticipantsComponent implements OnInit {


  eventId!: number;

  event: any;


  constructor(
    private route: ActivatedRoute,
    private eventParticipantsService: EventParticipantsService,
    private formBuilder: FormBuilder,
    private eventService: EventFormService
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


  eventForm = this.formBuilder.group({
    firstName: [''],
    lastName: [''],
    idNumber: [''],
    paymentMethod: [''],
    additionalInfo: ['']
  })


  onFormSubmit() {
    console.log("On submitting whole post...")
    console.log(`Value from form: [${JSON.stringify(this.eventForm.value)}]`)

    let event: any = {
      firstName: this.eventForm.value.firstName,
      lastName: this.eventForm.value.lastName,
      idNumber: this.eventForm.value.idNumber,
      paymentMethod: this.eventForm.value.paymentMethod,
      additionalInfo: this.eventForm.value.additionalInfo
    }

    this.eventParticipantsService.createNewPrivateClient(event).subscribe((data => {

      console.log(data)
        this.eventParticipantsService.mapping(this.eventId, data.id).subscribe((data => {

            console.log(this.event)
          })
        )
    })
    )
  }

}
