package me.rakshakhegde.cloveexercise.dependencies;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rakshakhegde on 25/05/17.
 */
@Module
public class AppModule {

	@Provides
	@Singleton
	public static Bus bus() {
		return new Bus();
	}
}
