package com.tuacy.animationdemo.viewanimation.tweenanimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RadioGroup;

import com.squareup.picasso.Picasso;
import com.tuacy.animationdemo.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class TweenAnimationActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, TweenAnimationActivity.class));
	}

	private Context         mContext;
	private CircleImageView mImageView;
	private RadioGroup      mRadioGroup;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tween_animaiton);
		mContext = this;
		initView();
		initEvent();
	}

	private void initView() {
		mImageView = findViewById(R.id.image_icon);
		Picasso.with(mContext)
			   .load("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1960816299,803825902&fm=27&gp=0.jpg")
			   .into(mImageView);
		mRadioGroup = findViewById(R.id.radio_group_tween_animation);
	}

	private void initEvent() {
		findViewById(R.id.button_transition).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				animTranslation();
			}
		});
		findViewById(R.id.button_scale).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				animScale();
			}
		});
		findViewById(R.id.button_rotate).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				animRotate();
			}
		});
		findViewById(R.id.button_alpha).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				animAlpha();
			}
		});
		findViewById(R.id.button_set).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				animSet();
			}
		});
	}

	private void animTranslation() {
		if (isXml()) {
			TranslateAnimation translate = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.translate);
			mImageView.startAnimation(translate);
		} else {
			TranslateAnimation translate = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 1, Animation.ABSOLUTE,
																  0, Animation.RELATIVE_TO_SELF, 1);
			translate.setDuration(2000);
			mImageView.startAnimation(translate);
		}
	}

	private void animScale() {
		if (isXml()) {
			ScaleAnimation scale = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.scale);
			mImageView.startAnimation(scale);
		} else {
			ScaleAnimation scale = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			scale.setDuration(2000);
			mImageView.startAnimation(scale);
		}
	}

	private void animAlpha() {
		if (isXml()) {
			AlphaAnimation alpha = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.alpha);
			mImageView.startAnimation(alpha);
		} else {
			AlphaAnimation alpha = new AlphaAnimation(1, 0);
			alpha.setDuration(2000);
			mImageView.startAnimation(alpha);
		}
	}

	private void animRotate() {
		if (isXml()) {
			RotateAnimation rotate = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.rotate);
			mImageView.startAnimation(rotate);
		} else {
			RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			rotate.setDuration(2000);
			mImageView.startAnimation(rotate);
		}
	}

	private void animSet() {
		if (isXml()) {
			AnimationSet set = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.set);
			mImageView.startAnimation(set);
		} else {
			AnimationSet set = new AnimationSet(true);
			set.setDuration(2000);
			set.setInterpolator(new LinearInterpolator());
			AnimationSet childSet = new AnimationSet(true);
			TranslateAnimation translate = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 1, Animation.ABSOLUTE,
																  0, Animation.RELATIVE_TO_SELF, 1);
			RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			childSet.addAnimation(translate);
			childSet.addAnimation(rotate);
			AlphaAnimation alpha = new AlphaAnimation(1, 0);
			set.addAnimation(childSet);
			set.addAnimation(alpha);
			mImageView.startAnimation(set);
		}
	}

	private boolean isXml() {
		return mRadioGroup.getCheckedRadioButtonId() == R.id.radio_tween_animation_xml;
	}
}
