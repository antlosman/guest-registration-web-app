import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PastEventParticipantsComponent } from './past-event-participants.component';

describe('PastEventParticipantsComponent', () => {
  let component: PastEventParticipantsComponent;
  let fixture: ComponentFixture<PastEventParticipantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PastEventParticipantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PastEventParticipantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
