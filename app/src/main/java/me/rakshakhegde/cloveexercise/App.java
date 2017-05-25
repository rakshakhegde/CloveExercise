package me.rakshakhegde.cloveexercise;

import com.squareup.leakcanary.LeakCanary;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import me.rakshakhegde.cloveexercise.dependencies.DaggerAppComponent;

/**
 * Created by rakshakhegde on 25/05/17.
 */

public class App extends DaggerApplication {
	@Override
	protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
		return DaggerAppComponent
				.builder()
				.create(this);
	}

	@Override
	public void onCreate() {
		super.onCreate();

		if (LeakCanary.isInAnalyzerProcess(this)) {
			// This process is dedicated to LeakCanary for heap analysis.
			// You should not init your app in this process.
			return;
		}
		LeakCanary.install(this);
	}
}
