import { TestBed } from '@angular/core/testing';

import { PastEventsServiceService } from './past-events-service.service';

describe('PastEventsServiceService', () => {
  let service: PastEventsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PastEventsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
