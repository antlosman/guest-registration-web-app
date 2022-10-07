import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePrivateClientComponent } from './update-private-client.component';

describe('UpdatePrivateClientComponent', () => {
  let component: UpdatePrivateClientComponent;
  let fixture: ComponentFixture<UpdatePrivateClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePrivateClientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePrivateClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
