package com.tuacy.animationdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tuacy.animationdemo.propertyanimation.PropertyAnimationActivity;
import com.tuacy.animationdemo.viewanimation.ViewAnimationActivity;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		findViewById(R.id.button_property_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PropertyAnimationActivity.startUp(mContext);
			}
		});

		findViewById(R.id.button_view_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ViewAnimationActivity.startUp(mContext);
			}
		});
	}
}
