package me.rakshakhegde.cloveexercise.components;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class TenSecDataBindingService extends IntentService {

	private final long DELAY_MILLIS = 10 * 1000;
	@Inject
	DataModel model;
	private Handler handler = new Handler();

	public TenSecDataBindingService() {
		super("TenSecDataBindingService");
	}

	@Override
	public void onCreate() {
		AndroidInjection.inject(this);
		super.onCreate();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				model.data.set("Message from Data Binding");
			}
		}, DELAY_MILLIS);
	}
}
