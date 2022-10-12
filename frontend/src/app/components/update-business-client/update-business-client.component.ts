import { Component, OnInit } from '@angular/core';
import { EventParticipantsService } from "../../services/event-participants.service";
import { ActivatedRoute } from "@angular/router";
import {FormBuilder, Validators } from "@angular/forms";

@Component({
  selector: 'app-update-business-client',
  templateUrl: './update-business-client.component.html',
  styleUrls: ['./update-business-client.component.css']
})
export class UpdateBusinessClientComponent implements OnInit {

  businessClient: any
  id: any

  constructor(
    private eventParticipantsService: EventParticipantsService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.eventParticipantsService.getBusinessClientByID(this.id).subscribe(data =>{
      this.businessClient = data
    }, error => console.log(error))
  }

  businessClientForm = this.formBuilder.group({
    companyName: ['', [Validators.required, Validators.nullValidator]],
    registerCode: ['', [Validators.required, Validators.nullValidator]],
    participantsQuantity: ['', [Validators.required, Validators.min(1)]],
    bClientPaymentMethod: [''],
    additionalInfo: ['']
  })

  onSubmit() {
    console.log("On submitting whole form...")
    console.log(`Value from form: [${JSON.stringify(this.id, this.businessClientForm.value)}]`)

    this.eventParticipantsService.updateBusinessClient(this.id, this.businessClient).subscribe()
  }

}
