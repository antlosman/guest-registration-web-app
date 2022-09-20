import { TestBed } from '@angular/core/testing';

import { FutureEventsService } from './future-events.service';

describe('FutureEventsService', () => {
  let service: FutureEventsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FutureEventsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
