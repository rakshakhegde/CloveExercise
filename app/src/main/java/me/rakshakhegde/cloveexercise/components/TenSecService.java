package me.rakshakhegde.cloveexercise.components;

import android.app.IntentService;
import android.content.Intent;

import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class TenSecService extends IntentService {

	@Inject
	Bus bus;

	public TenSecService() {
		super("TenSecService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		bus.post("Message from Otto");
	}
}
