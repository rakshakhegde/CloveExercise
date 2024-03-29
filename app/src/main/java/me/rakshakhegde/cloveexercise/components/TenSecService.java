package me.rakshakhegde.cloveexercise.components;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class TenSecService extends IntentService {

	private final long DELAY_MILLIS = 10 * 1000;
	@Inject
	Bus bus;
	private Handler handler = new Handler();

	public TenSecService() {
		super("TenSecService");
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
				bus.post("Message from Otto");
			}
		}, DELAY_MILLIS);
	}
}
