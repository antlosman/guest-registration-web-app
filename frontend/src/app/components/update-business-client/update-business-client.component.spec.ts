import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBusinessClientComponent } from './update-business-client.component';

describe('UpdateBusinessClientComponent', () => {
  let component: UpdateBusinessClientComponent;
  let fixture: ComponentFixture<UpdateBusinessClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateBusinessClientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateBusinessClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
