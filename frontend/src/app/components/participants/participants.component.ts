import { Component, OnInit } from '@angular/core';
import { EventParticipantsService } from "../../services/event-participants.service";
import { ActivatedRoute, Router } from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-participants',
  templateUrl: './participants.component.html',
  styleUrls: ['./participants.component.css']
})

export class ParticipantsComponent implements OnInit {

  eventId: any;
  event: any;

  isValidFormSubmitted = false;

  constructor(
    private route: ActivatedRoute,
    private eventParticipantsService: EventParticipantsService,
    private formBuilder: FormBuilder,
    private router: Router
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

  updatePrivateClient(id: number) {
    this.router.navigate(['update-privateClient-by-id', id])
  }

  // deletePrivateClient(id: number) {
  //   this.eventParticipantsService.deletePrivateClient(id).subscribe()
  // }

  onDeletePrivateClient(id: any) {
    console.log("id", id)
    this.eventParticipantsService.deletePrivateClient(id).subscribe((data: any) => {
      console.log(data)
      this.event.eventParticipant = data
    })
  }

  onDeleteBusinessClient(id: any) {
    console.log("id", id)
    this.eventParticipantsService.deleteBusinessClient(id).subscribe((data: any) => {
      console.log(data)
      this.event.eventParticipant = data
    })
  }

  privateClientForm = this.formBuilder.group({
    firstName: ['', [Validators.required, Validators.nullValidator]],
    lastName: ['', [Validators.required, Validators.nullValidator]],
    idNumber: ['', [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
    paymentMethod: [''],
    additionalInfo: ['']
  })

  businessClientForm = this.formBuilder.group({
    companyName: ['', [Validators.required, Validators.nullValidator]],
    registerCode: ['', [Validators.required, Validators.nullValidator]],
    participantsQuantity: ['', [Validators.required, Validators.min(1)]],
    bClientPaymentMethod: [''],
    bClientAdditionalInfo: ['']
  })

  onFormSubmit() {
    console.log("On submitting whole post...")
    console.log(`Value from form: [${JSON.stringify(this.privateClientForm.value)}]`)

    if (this.privateClientForm.invalid) {
      return;
    }

    this.isValidFormSubmitted = true;

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

    this.privateClientForm.reset()
  }

  onBusinessClientFormSubmit() {
    console.log("On submitting whole form...")
    console.log(`Value from form: [${JSON.stringify(this.businessClientForm.value)}]`)

    if (this.businessClientForm.invalid) {
      return;
    }

    this.isValidFormSubmitted = true;

    let event: any = {
      companyName: this.businessClientForm.value.companyName,
      registerCode: this.businessClientForm.value.registerCode,
      participantsQuantity: this.businessClientForm.value.participantsQuantity,
      bClientPaymentMethod: this.businessClientForm.value.paymentMethod,
      bClientAdditionalInfo: this.businessClientForm.value.additionalInfo
    }

    this.eventParticipantsService.createNewBusinessClient(event).subscribe((data => {

        console.log(data)
        this.eventParticipantsService.mappingBusinessClient(this.eventId, data.id).subscribe(( _data => {
            console.log(this.event)
          })
        )
      })
    )

    this.businessClientForm.reset()
  }

}
