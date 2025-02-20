import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { JokesService } from './services/jokes.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

describe('AppComponent', () => {
  let jokesServiceSpy: jasmine.SpyObj<JokesService>;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('JokesService', [
      'getRandomJoke',
      'joke$',
    ]);

    await TestBed.configureTestingModule({
      declarations: [AppComponent],
      imports: [HttpClientTestingModule],
      providers: [{ provide: JokesService, useValue: spy }],
    }).compileComponents();

    jokesServiceSpy = TestBed.inject(
      JokesService
    ) as jasmine.SpyObj<JokesService>;
    jokesServiceSpy.joke$.and.returnValue(of(null));
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should call getRandomJoke on ngOnInit', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    spyOn(app, 'getRandomJoke');

    app.ngOnInit();

    expect(app.getRandomJoke).toHaveBeenCalled();
  });

  it('should call jokesService.getRandomJoke when getRandomJoke is called', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;

    app.getRandomJoke();

    expect(jokesServiceSpy.getRandomJoke).toHaveBeenCalled();
  });
});
