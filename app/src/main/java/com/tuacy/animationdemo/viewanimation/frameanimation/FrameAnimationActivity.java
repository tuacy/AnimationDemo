package com.tuacy.animationdemo.viewanimation.frameanimation;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.tuacy.animationdemo.R;

public class FrameAnimationActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, FrameAnimationActivity.class));
	}

	private Context    mContext;
	private RadioGroup mRadioGroup;
	private ImageView  mImageAnimation;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_animaiton);
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRadioGroup = findViewById(R.id.radio_group_frame_animation);
		mImageAnimation = findViewById(R.id.image_frame_animation);
	}

	private void initEvent() {
		findViewById(R.id.button_start_frame_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (mRadioGroup.getCheckedRadioButtonId()) {
					case R.id.radio_frame_animation_xml:
						startXmlAnimation();
						break;
					case R.id.radio_frame_animation_java:
						startJavaAnimation();
						break;
				}
				AnimationDrawable animationDrawable = (AnimationDrawable) mImageAnimation.getDrawable();
				animationDrawable.start();
			}
		});
		findViewById(R.id.button_end_frame_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AnimationDrawable animationDrawable = (AnimationDrawable) mImageAnimation.getDrawable();
				if(animationDrawable != null) {
					animationDrawable.stop();
				}
			}
		});
	}

	private void initData() {

	}

	private void startXmlAnimation() {
		mImageAnimation.setImageResource(R.drawable.frame_animation);
	}

	private void startJavaAnimation() {
		AnimationDrawable animationDrawable = new AnimationDrawable();
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao1), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao2), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao3), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao4), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao5), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao6), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao7), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao8), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao9), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao10), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao11), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao12), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao13), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao14), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao15), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao16), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao17), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao18), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao19), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao20), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao21), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao22), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao23), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao24), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao25), 80);
		animationDrawable.addFrame(getResources().getDrawable(R.mipmap.img_miao26), 80);
		animationDrawable.setOneShot(false);
		mImageAnimation.setBackgroundDrawable(animationDrawable);
	}
}
