package me.rakshakhegde.cloveexercise.dependencies;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.rakshakhegde.cloveexercise.components.DataModel;

/**
 * Created by rakshakhegde on 25/05/17.
 */
@Module
class AppModule {

	@Provides
	@Singleton
	static Bus bus() {
		return new Bus(ThreadEnforcer.ANY);
	}

	@Provides
	@Singleton
	static DataModel dataModel() {
		return new DataModel();
	}
}
