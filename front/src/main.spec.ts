import { enableProdMode, NgModuleRef } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

describe('main.ts', () => {
  let enableProdModeSpy: jasmine.Spy;
  let bootstrapModuleSpy: jasmine.Spy;

  beforeEach(() => {
    enableProdModeSpy = spyOn(console, 'error');
    bootstrapModuleSpy = spyOn(
      platformBrowserDynamic(),
      'bootstrapModule'
    ).and.callFake(() => Promise.resolve({} as NgModuleRef<any>));
  });

  afterEach(() => {
    enableProdModeSpy.calls.reset();
    bootstrapModuleSpy.calls.reset();
  });

  it('should enable production mode if environment is production', () => {
    (environment as any).production = true;
    require('./main');

    expect(enableProdMode).toHaveBeenCalled();
  });

  it('should not enable production mode if environment is not production', () => {
    (environment as any).production = false;
    require('./main');

    expect(enableProdMode).not.toHaveBeenCalled();
  });

  it('should bootstrap AppModule', () => {
    require('./main');

    expect(bootstrapModuleSpy).toHaveBeenCalledWith(AppModule);
  });

  it('should log an error if bootstrap fails', async () => {
    const error = new Error('Bootstrap error');
    bootstrapModuleSpy.and.returnValue(Promise.reject(error));

    try {
      require('./main');
      await new Promise((resolve) => setTimeout(resolve, 0));
    } catch {}

    expect(console.error).toHaveBeenCalledWith(error);
  });
});
