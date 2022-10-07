import { Component, OnInit } from '@angular/core';
import { EventParticipantsService } from "../../services/event-participants.service";
import { ActivatedRoute } from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-update-private-client',
  templateUrl: './update-private-client.component.html',
  styleUrls: ['./update-private-client.component.css']
})
export class UpdatePrivateClientComponent implements OnInit {

  privateClient: any
  id: any

  constructor(
    private eventParticipantsService: EventParticipantsService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder)
{ }


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.eventParticipantsService.getPrivateClientById(this.id).subscribe(data =>{
      this.privateClient = data
    }, error => console.log(error))
  }

  // ngOnInit(): void {
  //   this.id = this.route.snapshot.params['id']
  //   this.privateClient = this.eventParticipantsService.getPrivateClientById(this.id).subscribe(
  //     data => {this.privateClient = data}, error => console.log(error)
  //   )
  // }

  privateClientForm = this.formBuilder.group({
    firstName: ['', [Validators.required, Validators.nullValidator]],
    lastName: ['', [Validators.required, Validators.nullValidator]],
    idNumber: ['', [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
    paymentMethod: [''],
    additionalInfo: ['']
  })

  onSubmit() {
    console.log("On submitting whole post...")
    console.log(`Value from form: [${JSON.stringify(this.id, this.privateClientForm.value)}]`)

    this.eventParticipantsService.updatePrivateClient(this.id, this.privateClient).subscribe()
  }

}
