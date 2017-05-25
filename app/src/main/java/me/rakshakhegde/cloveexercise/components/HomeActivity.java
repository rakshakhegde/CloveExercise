package me.rakshakhegde.cloveexercise.components;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

		bus.register(this);
	}

	@Subscribe
	public void messageArrived(String message) {
		msgTV.setText(message);
	}

	@Override
	protected void onStop() {
		bus.unregister(this);
		super.onStop();
	}
}
