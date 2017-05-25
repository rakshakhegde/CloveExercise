package me.rakshakhegde.cloveexercise.components;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import me.rakshakhegde.cloveexercise.R;

public class HomeActivity extends AppCompatActivity {

	@Inject
	Bus bus;

	private TextView msgTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		AndroidInjection.inject(this);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		msgTV = (TextView) findViewById(R.id.msgTV);

		findViewById(R.id.startServiceBtn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(new Intent(getApplicationContext(), TenSecService.class));
			}
		});

		bus.register(this);
	}

	@Subscribe
	public void messageArrived(final String message) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				msgTV.setText(message);
			}
		});
	}

	@Override
	protected void onStop() {
		bus.unregister(this);
		super.onStop();
	}
}
