import { TestBed, inject } from '@angular/core/testing';

import { JobpostsService } from './jobposts.service';

describe('JobpostsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JobpostsService]
    });
  });

  it('should be created', inject([JobpostsService], (service: JobpostsService) => {
    expect(service).toBeTruthy();
  }));
});
