import * as angularCore from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
import { environment } from './environments/environment';
import { core } from '@angular/compiler';

describe('main.ts', () => {
  let enableProdModeSpy: jasmine.Spy;
  let bootstrapModuleSpy: jasmine.Spy;

  beforeEach(() => {
    const mockNgModuleRef = {} as angularCore.NgModuleRef<unknown>;
    enableProdModeSpy = spyOn(angularCore, 'enableProdMode');
    bootstrapModuleSpy = spyOn(
      platformBrowserDynamic(),
      'bootstrapModule'
    ).and.returnValue(Promise.resolve(mockNgModuleRef));
  });

  afterEach(() => {
    enableProdModeSpy.calls.reset();
    bootstrapModuleSpy.calls.reset();
  });

  it('should enable production mode if environment is production', async () => {
    (environment as any).production = true;

    await import('./main');

    expect(enableProdModeSpy).toHaveBeenCalled();
  });

  it('should not enable production mode if environment is not production', async () => {
    (environment as any).production = false;

    await import('./main');

    expect(enableProdModeSpy).not.toHaveBeenCalled();
  });

  it('should bootstrap AppModule', async () => {
    await import('./main');

    expect(bootstrapModuleSpy).toHaveBeenCalledWith(AppModule);
  });

  it('should log an error if bootstrap fails', async () => {
    const error = new Error('Bootstrap error');
    bootstrapModuleSpy.and.returnValue(Promise.reject(error));
    const consoleErrorSpy = spyOn(console, 'error');

    try {
      await import('./main');
    } catch {}

    expect(consoleErrorSpy).toHaveBeenCalledWith(error);
  });
});
