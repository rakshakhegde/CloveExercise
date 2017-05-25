package me.rakshakhegde.cloveexercise.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import me.rakshakhegde.cloveexercise.App;

/**
 * Created by rakshakhegde on 25/05/17.
 */
@Singleton
@Component(modules = {
		AndroidSupportInjectionModule.class,
		InjectorsModule.class,
		AppModule.class
})
interface AppComponent extends AndroidInjector<App> {

	@Component.Builder
	abstract class Builder extends AndroidInjector.Builder<App> {
	}
}
