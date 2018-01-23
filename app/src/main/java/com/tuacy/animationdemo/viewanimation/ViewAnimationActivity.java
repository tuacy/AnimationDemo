package com.tuacy.animationdemo.viewanimation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tuacy.animationdemo.R;
import com.tuacy.animationdemo.viewanimation.frameanimation.FrameAnimationActivity;
import com.tuacy.animationdemo.viewanimation.tweenanimation.TweenAnimationActivity;

public class ViewAnimationActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, ViewAnimationActivity.class));
	}

	private Context mContext;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_animaiton);
		mContext = this;
		findViewById(R.id.button_tween_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TweenAnimationActivity.startUp(mContext);
			}
		});

		findViewById(R.id.button_frame_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FrameAnimationActivity.startUp(mContext);
			}
		});
	}
}
