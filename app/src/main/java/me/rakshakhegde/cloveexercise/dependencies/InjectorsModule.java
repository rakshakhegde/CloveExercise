package me.rakshakhegde.cloveexercise.dependencies;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.rakshakhegde.cloveexercise.components.HomeActivity;
import me.rakshakhegde.cloveexercise.components.TenSecService;

/**
 * Created by rakshakhegde on 25/05/17.
 */

@Module
abstract class InjectorsModule {

	@ContributesAndroidInjector
	abstract HomeActivity homeActivity();

	@ContributesAndroidInjector
	abstract TenSecService tenSecService();
}
