package com.tuacy.animationdemo.viewanimation.tweenanimation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tuacy.animationdemo.R;

public class TweenAnimationActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, TweenAnimationActivity.class));
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tween_animaiton);
	}
}
