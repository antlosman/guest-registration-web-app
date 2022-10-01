import { Component, OnInit } from '@angular/core';
import { EventParticipantsService } from "../../services/event-participants.service";
import { ActivatedRoute } from "@angular/router";
import { FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-participants',
  templateUrl: './participants.component.html',
  styleUrls: ['./participants.component.css']
})
export class ParticipantsComponent implements OnInit {


  eventId: any;
  event: any;

  constructor(
    private route: ActivatedRoute,
    private eventParticipantsService: EventParticipantsService,
    private formBuilder: FormBuilder,
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

  privateClientForm = this.formBuilder.group({
    firstName: [''],
    lastName: [''],
    idNumber: [''],
    paymentMethod: [''],
    additionalInfo: ['']
  })

  onFormSubmit() {
    console.log("On submitting whole post...")
    console.log(`Value from form: [${JSON.stringify(this.privateClientForm.value)}]`)

    let event: any = {
      firstName: this.privateClientForm.value.firstName,
      lastName: this.privateClientForm.value.lastName,
      idNumber: this.privateClientForm.value.idNumber,
      paymentMethod: this.privateClientForm.value.paymentMethod,
      additionalInfo: this.privateClientForm.value.additionalInfo
    }

    this.eventParticipantsService.createNewPrivateClient(event).subscribe((data => {

      console.log(data)
        this.eventParticipantsService.mapping(this.eventId, data.id).subscribe(( _data => {

            console.log(this.event)
          })
        )
    })
    )
  }

}
