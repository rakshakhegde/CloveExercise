package me.rakshakhegde.cloveexercise.components;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import me.rakshakhegde.cloveexercise.R;
import me.rakshakhegde.cloveexercise.databinding.ActivityDataBindingImplBinding;

public class DataBindingImplActivity extends AppCompatActivity {

	@Inject
	DataModel model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		AndroidInjection.inject(this);

		super.onCreate(savedInstanceState);
		ActivityDataBindingImplBinding binding =
				DataBindingUtil.setContentView(this, R.layout.activity_data_binding_impl);

		binding.setModel(model);

		binding.startServiceBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(new Intent(getApplicationContext(), TenSecDataBindingService.class));
			}
		});
	}
}
